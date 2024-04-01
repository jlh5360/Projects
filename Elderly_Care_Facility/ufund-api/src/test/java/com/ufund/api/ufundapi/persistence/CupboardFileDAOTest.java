package com.ufund.api.ufundapi.persistence;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.ufund.api.ufundapi.model.Need;

@Tag("FileDAO-tier")
public class CupboardFileDAOTest {
    private CupboardFileDAO mockUfundDAO;
    private Need[] testNeeds;

    @BeforeEach
    public void setUpCupboardFileDAO() throws IOException {
        // mockUfundDAO = mock(CupboardFileDAO.class);
        mockUfundDAO = spy(new CupboardFileDAO("data/needs.json", null));
        
        testNeeds = new Need[3];
        testNeeds[0] = new Need(1, "test-need", 1.0, 1, null);
        testNeeds[1] = new Need(2, "test-created-need", 15.95, 5, null);
        testNeeds[2] = new Need(3, "Monkey", 15.95, 5, "Likes Banana");

        mockUfundDAO.createNeed(testNeeds[0]);
        mockUfundDAO.createNeed(testNeeds[1]);
        mockUfundDAO.createNeed(testNeeds[2]);
    }

    @Test
    public void testGetNeeds() throws IOException {
        Need[] needs = testNeeds.clone();
        Need[] gottenNeeds = mockUfundDAO.getNeeds();

        assertArrayEquals(needs, gottenNeeds);
    }

    @Test
    public void testSearchNeeds() throws IOException {
        Need[] needs = new Need[2];
        needs[0] = new Need(1, "test-need", 1.0, 1, null);
        needs[1] = new Need(2, "test-created-need", 15.95, 5, null);
        Need[] gottenNeeds = mockUfundDAO.searchNeeds("test");

        assertArrayEquals(needs, gottenNeeds);
    }
    
    @Test
    public void testCreateNeed() throws IOException {
        Need need = new Need(4, "mock-test-need", 22.25, 32, "I am a mock test description.");

        Need newNeed = mockUfundDAO.createNeed(need);
        assertEquals(need, newNeed);
    }

    @Test
    public void testUpdateNeed() throws IOException {
        Need updatedNeed = new Need(1, "updated-need", 1.0, 1, null);

        assertEquals(updatedNeed, mockUfundDAO.updateNeed(new Need(1, "updated-need", 1.0, 1, null)));
        assertEquals(null, mockUfundDAO.updateNeed(new Need(0, "updated-need", 1.0, 1, null)));
        assertEquals(null, mockUfundDAO.updateNeed(new Need(99, "updated-need", 1.0, 1, null)));
    }

    @Test
    public void testDeleteNeed() throws IOException {
        Need need = new Need(1, "test-need", 1.0, 1, null);
        
        assertEquals(need, mockUfundDAO.deleteNeed(1));
    }

    @Test
    public void testGetNeed() throws IOException {
        Need need = new Need(1, "test-need", 1.0, 1, null);
        assertEquals(need, mockUfundDAO.getNeed(1));
    }

}
