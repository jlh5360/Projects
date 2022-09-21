package minesweeper.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class LocationTest {


    //this tests a brand new instance of Location
    //a default location contains values for Row and Col
    @Test
    public void testNewLocation(){
        //setup
        Location location = new Location(3, 0, '-');

        //analyze
        assertEquals(location.getCol(), 0);
        assertEquals(location.getRow(), 3);
        assertEquals(location.getValue(), '-');
        assertTrue(location.isCovered());
        assertFalse(location.isMine());
    }

    @Test
    public void testEditedLocation(){
        //setup
        Location location = new Location(4, 17, '-');

        //invoke
        location.setAsMine();
        location.uncover();

        //analyze
        assertEquals(location.getValue(), 'M');
        assertTrue(location.isMine());
        assertEquals(location.getRow(), 4);
        assertEquals(location.getCol(), 17);
        assertFalse(location.isCovered());
    }


    //This tests to see whether 2 instances of location are equal
    //based on their Row/ Col values
    @Test
    public void testEqualLocations(){
        Location location1 = new Location(4, 3, '-');
        Location location2 = new Location(4, 2, '-');
        Location location3 = new Location(4, 3, 'm');
        Location location4 = new Location(16261, 572718, '-');

        //analyze
        assertEquals(location1, location3);
        assertNotEquals(location1, location2);
        assertNotEquals(location4, location1);
    }
    
}
