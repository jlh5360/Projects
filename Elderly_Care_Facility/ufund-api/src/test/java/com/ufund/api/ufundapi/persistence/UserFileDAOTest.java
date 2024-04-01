package com.ufund.api.ufundapi.persistence;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.ufund.api.ufundapi.model.Need;
import com.ufund.api.ufundapi.model.User;

@Tag("FileDAO-tier")
public class UserFileDAOTest {
    private UserFileDAO mockUserDAO;
    private CartFileDAO mockCartDAO;
    private User[] testUsers;

    @BeforeEach
    public void setUpUserFileDAO() throws IOException {

        mockCartDAO = spy(new CartFileDAO("doNotSave", null));
        mockUserDAO = spy(new UserFileDAO("doNotSave", null, mockCartDAO));
        
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
    public void testLoginSuccessIsAdmin() throws IOException {
        User testUser = new User(0, "admin", "admin", true, null, null);

        User attemptLogin = this.mockUserDAO.login(testUser);
        assertEquals(testUser, attemptLogin);
        assertEquals(true, attemptLogin.isAdmin());
    }

    @Test
    public void testLoginSuccessNotAdmin() throws IOException {
        User testUser = new User(1, "helper", "password", false, null, null);

        User attemptLogin = this.mockUserDAO.login(testUser);
        assertEquals(testUser, attemptLogin);
        assertEquals(false, attemptLogin.isAdmin());
    }

    @Test
    public void testLoginFailure() throws IOException {
        User testUser = new User(99, "Iam", "inyourwalls", true, null, null);

        User attemptLogin = this.mockUserDAO.login(testUser);
        assertEquals(null, attemptLogin);
    }

    @Test
    public void testLogoutSuccessIsAdmin() throws IOException {
        User testUser = new User(0, "admin", "admin", true, null, null);

        User attemptLogin = this.mockUserDAO.logout(testUser);
        assertEquals(testUser, attemptLogin);
        assertEquals(true, attemptLogin.isAdmin());
    }

    @Test
    public void testLogoutSuccessNotAdmin() throws IOException {
        User testUser = new User(1, "helper", "password", false, null, null);

        User attemptLogin = this.mockUserDAO.logout(testUser);
        assertEquals(testUser, attemptLogin);
        assertEquals(false, attemptLogin.isAdmin());
    }
    @Test
    public void testLogoutFailure() throws IOException {
        User testUser = new User(99, "Iam", "inyourwalls", true, null, null);

        User attemptLogin = this.mockUserDAO.logout(testUser);
        assertEquals(null, attemptLogin);
    }
}
