package com.ufund.api.ufundapi.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufund.api.ufundapi.model.Need;
import com.ufund.api.ufundapi.persistence.CartFileDAO;

@Tag("Controller-tier")
public class CartControllerTest {
    private CartController cartController;
    private CartFileDAO mockCartDAO;
    private Need[] testNeeds;

    @BeforeEach
    public void setUpUFundController() throws IOException {
        mockCartDAO = spy(new CartFileDAO("doNotSave", new ObjectMapper()));
        cartController = new CartController(mockCartDAO);
        
        testNeeds = new Need[2];
        testNeeds[0] = new Need(1, "test-need", 1.0, 1, null);
        testNeeds[1] = new Need(2, "test-created-need", 15.95, 5, null);

        mockCartDAO.addItem(testNeeds[0]);
        mockCartDAO.addItem(testNeeds[1]);
    }

    @Test
    public void testAddItem() throws IOException {
        Need need = new Need(3, "mock-test-need", 22.25, 32, null);
        ResponseEntity<Need> response = cartController.addItem(need);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(need, response.getBody());
    }

    @Test
    public void testAddItemFailed() throws IOException {
        Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
        when(mockCartDAO.addItem(need))
            .thenReturn(null);

        ResponseEntity<Need> response = cartController.addItem(need);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void testAddItemHandleException() throws IOException {
        Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
        doThrow(new IOException()).when(mockCartDAO).addItem(need);
        ResponseEntity<Need> response = cartController.addItem(need);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testRemoveItem() throws IOException { 

            Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
        
            when(mockCartDAO.removeItem(need.getId()))
                .thenReturn(need);
        
            ResponseEntity<Need> response = cartController.removeItem(need.getId());

            assertEquals(HttpStatus.OK,response.getStatusCode());
        }

    @Test
    public void testRemoveItemHandleException() throws IOException {
        doThrow(new IOException()).when(mockCartDAO).removeItem(0);
        ResponseEntity<Need> response = cartController.removeItem(0);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    
    @Test
    public void testRemoveItemFailed() throws IOException { 

        Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
     
        when(mockCartDAO.removeItem(need.getId()))
            .thenReturn(null);
    
        ResponseEntity<Need> response = cartController.removeItem(need.getId());

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    public void testCheckoutCart() throws IOException { 

        Need[] needs = new Need[2];
        needs[0] = new Need(1, "test-need", 1.0, 1, null);
        needs[1] = new Need(2, "test-created-need", 15.95, 5, null);

        when(mockCartDAO.emptyNeeds())
            .thenReturn(true);
    
        ResponseEntity<Need[]> response = cartController.clearCart();

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void testCheckoutCartFalse() throws IOException { 

        Need[] needs = new Need[2];
        needs[0] = new Need(1, "test-need", 1.0, 1, null);
        needs[1] = new Need(2, "test-created-need", 15.95, 5, null);

        when(mockCartDAO.emptyNeeds())
            .thenReturn(false);
    
        ResponseEntity<Need[]> response = cartController.clearCart();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testGetNeedsSuccess() {
        ResponseEntity<Need[]> response = cartController.getNeeds();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertArrayEquals(testNeeds, response.getBody());

    }

    @Test
    public void testGetNeedsEmpty() throws IOException {
        when(mockCartDAO.getNeeds())
            .thenReturn(null);

        ResponseEntity<Need[]> response = cartController.getNeeds();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testGetNeedsError() throws IOException {
        doThrow(new IOException()).when(mockCartDAO).getNeeds();

        ResponseEntity<Need[]> response = cartController.getNeeds();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

    }
}
