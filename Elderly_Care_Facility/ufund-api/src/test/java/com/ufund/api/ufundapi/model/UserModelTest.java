package com.ufund.api.ufundapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Model-tier")
public class UserModelTest {

    private User testUser;
    

    @BeforeEach
    public void setUpUserModelTest() {
        Need testNeed = new Need(1,"Cucumber",1.5, 1, null);
        Need[] testCart = new Need[1];
        testCart[0] = testNeed;

        testUser = new User(0, "admin", "admin", true, null, testCart);

    }

    @Test
    public void testSetPassword() {
        testUser.setPassword("banana");
        assertEquals("banana", testUser.getPassword());
    }

    @Test
    public void testEquals() {
        Need testNeed = new Need(1,"Cucumber",1.5, 1, null);
        Need[] testCart = new Need[1];
        testCart[0] = testNeed;

        User testUser = new User(0, "admin", "admin", true, null, testCart);
        User testUser2 = new User(0, "admin", "admin", true, null, testCart);

        assertEquals(false, testUser.equals(new Object()));
        
        assertEquals(testUser.hashCode(), testUser2.hashCode());
    }
}
