package com.ufund.api.ufundapi.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.after;
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
import com.ufund.api.ufundapi.model.Elderly;
import com.ufund.api.ufundapi.model.Need;
import com.ufund.api.ufundapi.persistence.AdoptionFileDAO;

@Tag("Controller-tier")
public class AdoptionControllerTest {
    private AdoptionController ufundController;
    private AdoptionFileDAO mockUfundDAO;
    private Elderly[] testElderlies;

    @BeforeEach
    public void setUpUFundController() throws IOException {
        mockUfundDAO = spy(new AdoptionFileDAO("doNotSave", new ObjectMapper()));
        ufundController = new AdoptionController(mockUfundDAO);
        
        testElderlies = new Elderly[2];
        testElderlies[0] = new Elderly(1, "test-elderlies", 75, "Male", "Medium", 2, null);
        testElderlies[1] = new Elderly(2, "test-elderlies", 80, "Female", "High", 3, null);

        mockUfundDAO.addElderly(testElderlies[0]);
        mockUfundDAO.addElderly(testElderlies[1]);
    }


    @Test
    public void testAddElderly() throws IOException {
        Elderly elder = new Elderly(3, "mock-test-elderly", 60, "Male", "Low", 1, null);
        ResponseEntity<Elderly> response = ufundController.addElderly(elder);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(elder, response.getBody());
    }

    @Test
    public void testAddItemFailed() throws IOException {
        Elderly elder = new Elderly(99, "mock-test-elderly-fail", 99, "Male", "High", 1, null);
        when(mockUfundDAO.addElderly(elder))
            .thenReturn(null);

        ResponseEntity<Elderly> response = ufundController.addElderly(elder);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    public void testAddItemHandleException() throws IOException {
        Elderly elder = new Elderly(99, "mock-test-elderly-fail", 99, "Male", "High", 1, null);
        doThrow(new IOException()).when(mockUfundDAO).addElderly(elder);
        ResponseEntity<Elderly> response = ufundController.addElderly(elder);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testRemoveElderly() throws IOException { 

            Elderly elder = new Elderly(3, "mock-test-elderly", 60, "Male", "Low", 1, null);
        
            when(mockUfundDAO.removeElderly(elder.getId()))
                .thenReturn(elder);
        
            ResponseEntity<Elderly> response = ufundController.removeElderly(elder.getId());

            assertEquals(HttpStatus.OK,response.getStatusCode());
        }

    @Test
    public void testRemoveElderlyHandleException() throws IOException {
        doThrow(new IOException()).when(mockUfundDAO).removeElderly(0);
        ResponseEntity<Elderly> response = ufundController.removeElderly(0);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
    
    @Test
    public void testRemoveElderlyFailed() throws IOException { 

        Elderly elder = new Elderly(99, "mock-test-elderly-fail", 99, "Male", "High", 1, null);
     
        when(mockUfundDAO.removeElderly(elder.getId()))
            .thenReturn(null);
    
        ResponseEntity<Elderly> response = ufundController.removeElderly(elder.getId());

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
  
  @Test
    public void testGetNeeds() throws IOException {
        // Set  up
        Elderly[] elder = new Elderly[2];
        elder[0] = new Elderly(1, "test-elderlies", 75, "Male", "Medium", 2, null);
        elder[1] = new Elderly(2, "test-elderlies", 80, "Female", "High", 3, null);

        // Mocking the DAO
        when(mockUfundDAO.getElderlies()).thenReturn(elder);

        // Invoke
        ResponseEntity<Elderly[]> response = ufundController.getElderlies();

        // Analyze
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(elder, response.getBody());
    }

    @Test
    public void testGetNeedsFailed() throws IOException {
        // Set  up
        Elderly[] elder = new Elderly[2];
        elder[0] = new Elderly(1, "test-elderlies", 75, "Male", "Medium", 2, null);
        elder[1] = new Elderly(2, "test-elderlies", 80, "Female", "High", 3, null);

        // Mocking the DAO
        when(mockUfundDAO.getElderlies()).thenReturn(null);

        // Invoke
        ResponseEntity<Elderly[]> response = ufundController.getElderlies();

        // Analyze
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void testGetNeedsHandleException() throws IOException {
        doThrow(new IOException()).when(mockUfundDAO).getElderlies();
        ResponseEntity<Elderly[]> response = ufundController.getElderlies();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testUpdate() throws IOException{
        Elderly elder = new Elderly(3, "mock-test-elderly", 60, "Male", "Low", 1, null);
        
        when(mockUfundDAO.updateElderly(elder)).thenReturn(elder);

        ResponseEntity<Elderly> response = ufundController.updateElderly(elder);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(elder, response.getBody());

    }

    @Test
    public void testUpdateNeedHandleException() throws IOException {
        Elderly elder = new Elderly(99, "mock-test-elderly-fail", 99, "Male", "High", 1, null);
        doThrow(new IOException()).when(mockUfundDAO).updateElderly(elder);
        ResponseEntity<Elderly> response = ufundController.updateElderly(elder);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testUpdateFailure() throws IOException{
        Elderly elder = new Elderly(99, "mock-test-elderly-fail", 99, "Male", "High", 1, null);
        
        when(mockUfundDAO.updateElderly(elder)).thenReturn(null);

        ResponseEntity<Elderly> response = ufundController.updateElderly(elder);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());

    }

}
