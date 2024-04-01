package com.ufund.api.ufundapi.controller;

import com.ufund.api.ufundapi.model.User;
import com.ufund.api.ufundapi.persistence.UserFileDAO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("ufundapi/users")
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    private UserFileDAO userDAO;

    public UserController(UserFileDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Login api call that attempts to see if the provided user is allowed
     * to login.
     *
     * Returns status code detailing if login was successful or not 
     * and boolean detailing if the user is admin.
     *
     * @param user 
     */
    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody User user) {
        // Log the POST request for user login
        LOG.info("POST /ufundapi/users/login");

        try {
            // Attempt to log in the user using the userDAO
            User attemptLogin = this.userDAO.login(user);

            // Check if the login attempt was successful
            if (attemptLogin != null) {
                // Return a success response with the user and HTTP status ACCEPTED (202)
                return new ResponseEntity<User>(attemptLogin, HttpStatus.ACCEPTED);
            } else {
                // Return an unauthorized response with HTTP status UNAUTHORIZED (401) if login was unsuccessful
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Signup api call that attempts to create the login credentials.
     *
     * Returns status code detailing if signup was successful or not 
     *
     * @param user 
     */
    @PostMapping("signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        // Log the POST request for user signup
        LOG.info("POST /ufundapi/users/signup");

        try {
            // Attempt to create a new user using the userDAO
            User signupUser = this.userDAO.createUser(user);

            // Check if the user signup was successful
            if (signupUser != null) {
                // Return a success response with the created user and HTTP status CREATED (201)
                return new ResponseEntity<User>(signupUser, HttpStatus.CREATED);
            } else {
                // Return an internal server error response with HTTP status INTERNAL SERVER ERROR (500) if signup was unsuccessful
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * logout api call that attempts to logout the provided user.
     *
     * Returns status code HTTP status of OK<br> if logout is successful
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     *
     * @param user 
     */
    @PostMapping("logout")
    public ResponseEntity<User> logout(@RequestBody User user) {
        // Log the POST request for user logout
        LOG.info("POST /ufundapi/users/logout");

        try {
            // Attempt to logout the user using the userDAO
            User logout_user = this.userDAO.logout(user);

            // Check if the user logout was successful
            if (logout_user != null) {
                // Return a success response with the logged-out user and HTTP status OK (200)
                return new ResponseEntity<User>(logout_user, HttpStatus.OK);
            } else {
                // Return an internal server error response with HTTP status INTERNAL SERVER ERROR (500) if logout was unsuccessful
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
        } catch (IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
