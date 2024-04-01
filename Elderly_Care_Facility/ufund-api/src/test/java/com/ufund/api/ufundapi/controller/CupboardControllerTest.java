package com.ufund.api.ufundapi.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
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
import com.ufund.api.ufundapi.persistence.CupboardFileDAO;

@Tag("Controller-tier")
public class CupboardControllerTest {
    private CupboardController ufundController;
    private CupboardFileDAO mockUfundDAO;
    private Need[] testNeeds;

    @BeforeEach
    public void setUpUFundController() throws IOException {
        // mockUfundDAO = mock(CupboardFileDAO.class);
        mockUfundDAO = spy(new CupboardFileDAO("doNotSave", new ObjectMapper()));
        ufundController = new CupboardController(mockUfundDAO);
        
        testNeeds = new Need[2];
        testNeeds[0] = new Need(1, "test-need", 1.0, 1, null);
        testNeeds[1] = new Need(2, "test-created-need", 15.95, 5, null);

        mockUfundDAO.createNeed(testNeeds[0]);
        mockUfundDAO.createNeed(testNeeds[1]);

    }

    @Test
    public void testNeedClass() throws IOException {
        Need need = new Need(99, "mock-test-need", 22.25, 32, "I am a mock test description.");

        assertEquals(99, need.getId());
        assertEquals("mock-test-need", need.getName());
        assertEquals(22.25, need.getCost());
        assertEquals(32, need.getAmount());
        assertEquals("I am a mock test description.", need.getDescription());

        need.setCost(69);
        assertEquals(69, need.getCost());

        need.setName("banana");
        assertEquals("banana", need.getName());

        need.setAmount(42);
        assertEquals(42, need.getAmount());

        need.setDescription("I am a Minion.");
        assertEquals("I am a Minion.", need.getDescription());
    }

    @Test
    public void testCreateNeed() throws IOException {
        Need need = new Need(3, "mock-test-need", 22.25, 32, null);
        // when(mockUfundDAO.createNeed(need))
            // .thenReturn(need);

        ResponseEntity<Need> response = ufundController.createNeed(need);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(need, response.getBody());
    }

    @Test
    public void testCreateNeedFailed() throws IOException {
        Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
        when(mockUfundDAO.createNeed(need))
            .thenReturn(null);

        ResponseEntity<Need> response = ufundController.createNeed(need);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void testCreateNeedHandleException() throws IOException {
        Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
        doThrow(new IOException()).when(mockUfundDAO).createNeed(need);
        ResponseEntity<Need> response = ufundController.createNeed(need);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testSearchNeeds() throws IOException {
        // Set  up
        Need[] needs = new Need[2];
        needs[0] = new Need(1, "test-need", 1.0, 1, null);
        needs[1] = new Need(2, "test-created-need", 15.95, 5, null);

        // Invoke
        ResponseEntity<Need[]> response = ufundController.searchNeeds("test");

        // Analyze
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertArrayEquals(needs, response.getBody());
    }

    @Test
    public void testSearchNeedsFailed() throws IOException {
        // Invoke
        ResponseEntity<Need[]> response = ufundController.searchNeeds("apple");

        // Analyze
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testSearchNeedsHandleException() throws IOException {
        // Set  up
        Need[] needs = new Need[2];
        needs[0] = new Need(1, "test-need", 1.0, 1, null);
        needs[1] = new Need(2, "test-created-need", 15.95, 5, null);

        // Mocking the DAO
        doThrow(new IOException()).when(mockUfundDAO).searchNeeds("test");

        // Invoke
        ResponseEntity<Need[]> response = ufundController.searchNeeds("test");

        // Analyze
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testDeleteNeedHandleException() throws IOException {
        doThrow(new IOException()).when(mockUfundDAO).deleteNeed(0);
        ResponseEntity<Need> response = ufundController.deleteNeed(0);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    
    @Test
    public void testDeleteNeed() throws IOException { 

        Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
     
        when(mockUfundDAO.deleteNeed(need.getId()))
            .thenReturn(need);
    
        ResponseEntity<Need> response = ufundController.deleteNeed(need.getId());

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
    
    @Test
    public void testDeleteNeedFailed() throws IOException { 

        Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
     
        when(mockUfundDAO.deleteNeed(need.getId()))
            .thenReturn(null);
    
        ResponseEntity<Need> response = ufundController.deleteNeed(need.getId());

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    public void testGetNeed() {

        Need need = new Need(99, "mock-test-need", 22.25, 32, null);
        when(mockUfundDAO.getNeed(1)).thenReturn(need);

        ResponseEntity<Need> response = ufundController.getNeedById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(need, response.getBody());

    }

    @Test
    public void testGetNeedFailure() {

        when(mockUfundDAO.getNeed(1)).thenReturn(null);

        ResponseEntity<Need> response = ufundController.getNeedById(1);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(null, response.getBody());

    }

    @Test
    public void testUpdate() throws IOException{
        Need need = new Need(1, "mock-test-need", 22.25, 32, null);
        
        when(mockUfundDAO.updateNeed(need)).thenReturn(need);

        ResponseEntity<Need> response = ufundController.updateNeed(need);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(need, response.getBody());

    }

    @Test
    public void testUpdateNeedHandleException() throws IOException {
        Need need = new Need(99, "mock-test-need-fail", 22.25, 32, null);
        doThrow(new IOException()).when(mockUfundDAO).updateNeed(need);
        ResponseEntity<Need> response = ufundController.updateNeed(need);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testUpdateFailure() throws IOException{
        Need need = new Need(99, "mock-test-need", 22.25, 32, null);
        
        when(mockUfundDAO.updateNeed(need)).thenReturn(null);

        ResponseEntity<Need> response = ufundController.updateNeed(need);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());

    }
    
    @Test
    public void testGetNeeds() throws IOException {
        // Set  up
        Need[] needs = new Need[2];
        needs[0] = new Need(1, "test-need", 1.0, 1, null);
        needs[1] = new Need(2, "test-created-need", 15.95, 5, null);

        // Mocking the DAO
        when(mockUfundDAO.getNeeds()).thenReturn(needs);

        // Invoke
        ResponseEntity<Need[]> response = ufundController.getNeeds();

        // Analyze
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(needs, response.getBody());
    }

    @Test
    public void testGetNeedsFailed() throws IOException {
        // Set  up
        Need[] needs = new Need[2];
        needs[0] = new Need(1, "test-need", 1.0, 1, null);
        needs[1] = new Need(2, "test-created-need", 15.95, 5, null);

        // Mocking the DAO
        when(mockUfundDAO.getNeeds()).thenReturn(null);

        // Invoke
        ResponseEntity<Need[]> response = ufundController.getNeeds();

        // Analyze
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void testGetNeedsHandleException() throws IOException {
        doThrow(new IOException()).when(mockUfundDAO).getNeeds();
        ResponseEntity<Need[]> response = ufundController.getNeeds();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
