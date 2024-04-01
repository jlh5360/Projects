package com.ufund.api.ufundapi.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import com.ufund.api.ufundapi.model.User;
import com.ufund.api.ufundapi.persistence.CartFileDAO;
import com.ufund.api.ufundapi.persistence.UserFileDAO;

@Tag("Controller-tier")
public class UserControllerTest {
    private UserController userController;
    private UserFileDAO mockUserDAO;
    private CartFileDAO mockCartDAO;
    private User[] testUsers;

    @BeforeEach
    public void setUpUFundController() throws IOException {
        mockCartDAO = spy(new CartFileDAO("doNotSave", null));
        
        mockUserDAO = spy(new UserFileDAO("doNotSave", null, mockCartDAO));
        userController = new UserController(mockUserDAO);
        
        Need testNeed = new Need(1,"Cucumber",1.5, 1, null);
        Need[] testCart = new Need[1];
        testCart[0] = testNeed;

        testUsers = new User[3];
        testUsers[0] = new User(0, "admin", "admin", true, null, testCart);
        testUsers[1] = new User(1, "helper", "password", false, null, testCart);

        mockUserDAO.createUser(testUsers[0]);
        mockUserDAO.createUser(testUsers[1]);
    }

    @Test
    public void testLoginSuccessIsAdmin() {
        Need testNeed = new Need(1,"Cucumber",1.5, 1, null);
        Need[] testCart = new Need[1];
        testCart[0] = testNeed;
        User testUser = new User(0, "admin", "admin", true, null, testCart);
        ResponseEntity<User> response = userController.login(testUser);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        User returnedUser = response.getBody();

        assertNotEquals(null, returnedUser);
        if (returnedUser != null) {
            assertEquals(true, returnedUser.isAdmin());
        }
    }

    @Test
    public void testLoginSuccessNotAdmin() {
        User testUser = new User(1, "helper", "password", false, null, null);
        ResponseEntity<User> response = userController.login(testUser);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        User returnedUser = response.getBody();

        assertNotEquals(null, returnedUser);
        if (returnedUser != null) {
            assertEquals(false, returnedUser.isAdmin());
        }
    }

    @Test
    public void testLoginFailure() {
        User testUser = new User(99, "minion", "banana", true, null, null);
        ResponseEntity<User> response = userController.login(testUser);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

}
