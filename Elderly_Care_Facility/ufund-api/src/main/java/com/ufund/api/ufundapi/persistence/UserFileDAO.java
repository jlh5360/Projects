package com.ufund.api.ufundapi.persistence;

import com.ufund.api.ufundapi.model.User;
import com.ufund.api.ufundapi.model.Need;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.io.File;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserFileDAO {

    Map<Integer, User> users;

    private static int nextId;
    private String filename;
    private ObjectMapper objectMapper;
    private CartFileDAO cartDAO;
    // private User currentUser;

    // Constructor for UserFileDAO class
    public UserFileDAO(@Value("data/users.json") String filename, 
            ObjectMapper objectMapper,
            CartFileDAO cartDAO) throws IOException {
        // Initialize the filename, objectMapper, and cartDAO
        this.filename = filename;
        this.objectMapper = objectMapper;
        this.cartDAO = cartDAO;

        // Load data from the specified file
        load();
    }

    // Get an array of User objects with optional filtering
    private User[] getUsersArray() {
        // Delegate to the overloaded method with a null filter
        return getUsersArray(null);
    }

    /**
     * Get an array of User objects with optional text filtering.
     *
     * @return arrayList of needs
     */
    private User[] getUsersArray(String containsText) {
        // Create an ArrayList to store filtered User objects
        ArrayList<User> userArrayList = new ArrayList<>();

        // Iterate over all User objects in the users map
        for (User need : users.values()) {
            // Check if the User object matches the filter criteria
            if (containsText == null || need.getName().contains(containsText)) {
                // Add the User object to the filtered list
                userArrayList.add(need);
            }
        }

        // Convert the ArrayList to an array and return it
        User[] needsArray = new User[userArrayList.size()];
        userArrayList.toArray(needsArray);
        return needsArray;
    }

    /**
     * A synchronized method to generate the next unique ID
     *
     * @return the next ID in line
     */
    private synchronized static int nextId() {
        // Retrieve the current value of nextId
        int id = nextId;

        // Increment nextId for the next invocation
        ++nextId;

        // Return the retrieved ID, ensuring thread safety
        return id;
    }

    /**
     * Saves current list of needs to a json file on the local system.
     *
     * @return True if succeeded
     * @throws IOException Throws if failed to save
     */
    private boolean saveUser() throws IOException {
        // Retrieve the array of User objects
        User[] usersArray = getUsersArray();

        // Check if ObjectMapper is not configured
        if (objectMapper == null) {
            // Return false if ObjectMapper is not configured
            return false;
        }

        // Check if the filename is set to "doNotSave"
        if ((filename != null) && (filename.equals("doNotSave"))){
            // Return true if the filename is set to "doNotSave"
            return true;
        }

        // Write the User array to the specified file using the ObjectMapper
        objectMapper.writeValue(new File(filename), usersArray);

        // Return true to indicate successful saving
        return true;
    }

    /**
     * Save an array of Need objects over the existing cart data.
     * Should only be run upon login.
     *
     * @param cart 
     * @return 
     * @throws IOException 
     */
    private boolean saveOverCart(Need[] cart) throws IOException {
        // Clear the existing cart data
        this.cartDAO.emptyNeeds();

        // Iterate over the provided array of Need objects
        for (Need need : cart) {
            // Add each Need to the cart
            this.cartDAO.addItem(need);
        }
        // Return true to indicate successful saving over the cart
        return true;
    }

    /**
     * Loads the list of needs from a local json file.
     *
     * @return True if succeeded in loading in needs from file
     * @throws IOException Throws if failed in loading from file
     */
    private boolean load() throws IOException {
        // Initialize or reset the users TreeMap and nextId
        this.users = new TreeMap<>();
        nextId = 1;

        // Check if ObjectMapper is not configured
        if (objectMapper == null) {
            // Return true if ObjectMapper is not configured
            return true;
        }

        // Check if the filename is set to "doNotSave"
        if ((filename != null) && (filename.equals("doNotSave"))) {
            // Return true if the filename is set to "doNotSave"
            return true;
        }

        // Read the array of User objects from the specified file using the ObjectMapper
        User[] userArray = objectMapper.readValue(new File(filename), User[].class);

        // Iterate over the array of User objects and populate the users TreeMap
        for (User user : userArray) {
            // Put each User object into the users TreeMap with its ID as the key
            users.put(user.getId(), user);

            // Update the nextId if the user's ID is greater
            if (user.getId() > nextId) {
                nextId = user.getId();
            }
        }

        // Increment nextId for the next unique ID
        ++nextId;
        // Return true to indicate successful loading of users from the file
        return true;
    }

    /**
     * Creates a new user and adds it to the system.
     *
     * @param user The user object containing details for the new user.
     * @return The newly created user.
     * @throws IOException Throws if there's an issue creating or saving the user.
     */
    public User createUser(User user) throws IOException {
        // Create a new user with a unique ID using the nextId method
        User newUser = new User(nextId(), 
                                user.getName(),
                                user.getPassword(),
                                user.isAdmin(),
                                user.getAdoptedElderly(),
                                user.getCart());
        
        // Put the newly created user into the users TreeMap with its ID as the key
        users.put(newUser.getId(), newUser);

        // Save the user data to the file
        saveUser();

        // Return the newly created user
        return newUser;
    }

    /**
     * Checks if a user exists in the user list loaded from the users.json file and allows login.
     *
     * @param logon_user The user object representing the user attempting to log in.
     * @return The user object if allowed to login, returns null otherwise.
     * @throws IOException Throws if there's an issue updating the cart or saving changes.
     */
    public User login(User logon_user) throws IOException {
        // Iterate over the existing users
        for (User user : users.values()) {
            // Check if user credentials match the provided logon_user
            if (user.getName().equals(logon_user.getName()) && 
                user.getPassword().equals(logon_user.getPassword())) {

                // Save the cart from the logged-in user to the cart.json file
                saveOverCart(user.getCart());
                // this.currentUser = user;

                // Return the user object if allowed to login
                return user;
            }
        }
        // Return null if the provided user credentials do not match any existing user
        return null;
    }

    /**
     * Logs out a user by updating their cart and saving the changes.
     *
     * @param logout_user The user object representing the user to be logged out.
     * @return The logged-out user with updated cart.
     *         Returns null if the provided user credentials do not match any existing user.
     * @throws IOException Throws if there's an issue updating or saving the user.
     */
    public User logout(User logout_user) throws IOException {
        // Iterate over the existing users
        for (User user : users.values()) {
            // Check if user credentials match the provided logout_user
            if (user.getName().equals(logout_user.getName()) && 
                user.getPassword().equals(logout_user.getPassword())) {

                // Update the user's cart with the cart from logout_user
                user.setCart(logout_user.getCart());

                // Replace the existing user in the users TreeMap with the updated user
                users.replace(user.getId(), user);

                // Save the user data to the file
                saveUser();
                // Return the logged-out user with the updated cart
                return user;
            }

        }
        // Return null if the provided user credentials do not match any existing user
        return null;
    }
}
