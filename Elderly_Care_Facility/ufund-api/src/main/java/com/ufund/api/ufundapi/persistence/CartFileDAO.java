package com.ufund.api.ufundapi.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufund.api.ufundapi.model.Need;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;

@Component
public class CartFileDAO {

    private final Map<Integer, Need> cart = new TreeMap<>();

    private static int nextId;
    private String filename;
    private ObjectMapper objectMapper;
    
    // Constructor for CartFileDAO class
    public CartFileDAO(@Value("data/cart.json") String filename, ObjectMapper objectMapper) throws IOException {
        // Initialize the filename and objectMapper
        this.filename = filename;
        this.objectMapper = objectMapper;

        // Load data from the specified file
        load();
    }

    // A synchronized method to generate the next unique ID
    private synchronized static int nextId() {
        // Retrieve the current value of nextId
        int id = nextId;

        // Increment nextId for the next invocation
        ++nextId;

        // Return the retrieved ID, ensuring thread safety
        return id;
    }

    // A convenience method to get an array of Need objects with optional filtering
    private Need[] getNeedsArray() {
        // Delegate to the overloaded method with null as the filter
        return getNeedsArray(null);
    }

    /**
     * Retrieve an array of needs to a json file on the local system.
     *
     * @return an array of needs
     */
    private Need[] getNeedsArray(String containsText) {
        // Create an ArrayList to store filtered Need objects
        ArrayList<Need> needArrayList = new ArrayList<>();

        // Iterate over all Need objects in the cart map
        for (Need need : cart.values()) {
            // Check if the Need object matches the filter criteria
            if (containsText == null || need.getName().contains(containsText)) {
                // Add the Need object to the filtered list
                needArrayList.add(need);
            }
        }

        // Convert the ArrayList to an array and return it
        Need[] needsArray = new Need[needArrayList.size()];
        needArrayList.toArray(needsArray);
        return needsArray;
    }

    /**
     * Saves current list of needs to a json file on the local system.
     *
     * @return True if succeeded
     * @throws IOException Throws if failed to save
     */
    private boolean save() throws IOException {
        // Check if ObjectMapper is not configured
        if (objectMapper == null) {
            // Unable to save if ObjectMapper is not configured
            return false;
        }
    
        // Check if the filename is set to "doNotSave"
        if ("doNotSave".equals(filename)) {
            // Skip saving if the filename is set to "doNotSave"
            return true;
        }
    
        // Retrieve an array of Need objects
        Need[] needsArray = getNeedsArray();
    
        // Write the Need array to the specified file using the ObjectMapper
        objectMapper.writeValue(new File(filename), needsArray);
    
        // Save operation completed successfully
        return true;
    }

    /**
     * Loads the list of needs from a local json file.
     *
     * @return True if succeeded in loading in needs from file
     * @throws IOException Throws if failed in loading from file
     */
    private boolean load() throws IOException {
        // Initialize the cart TreeMap and reset the nextId counter
        nextId = 1;
    
        // Check if ObjectMapper is not configured
        if (objectMapper == null) {
            // Unable to load if ObjectMapper is not configured
            return false;
        }
    
        // Check if the filename is set to "doNotSave"
        if ("doNotSave".equals(filename)) {
            // Skip loading if the filename is set to "doNotSave"
            return true;
        }
    
        // Read Need array from the specified file using the ObjectMapper
        Need[] needArray = objectMapper.readValue(new File(filename), Need[].class);
    
        // Populate the cart TreeMap with Need objects and update the nextId counter
        for (Need need : needArray) {
            cart.put(need.getId(), need);
    
            // Update the nextId counter based on the maximum Need ID in the loaded data
            if (need.getId() > nextId) {
                nextId = need.getId();
            }
        }
    
        // Increment the nextId counter to ensure uniqueness for future IDs
        ++nextId;
    
        // Load operation completed successfully
        return true;
    }

    /**
     * Add a need into the cart 
     * 
     * @param need Need that is to be added
     * @return The need that was added
     */
    public Need addItem(Need need) throws IOException {
        Need newItem = new Need(nextId(), 
                                          need.getName(), 
                                          need.getCost(), 
                                          need.getAmount(),
                                          need.getDescription());
        cart.put(newItem.getId(), newItem);
        save();
        return newItem;
    }

    /**
     * Remove a need from the cart.
     * 
     * @param need Need that is to be removed
     * @return The need that was deleted
     */
    public Need removeItem(int id) throws IOException {
        // Remove the Need with the specified ID from the cart TreeMap
        Need deleted = cart.remove(id);
    
        try {
            // Persist the changes by saving to the file (may throw an IOException)
            save();
        } catch (IOException e) {
            // Log the exception or handle it as needed
            // For simplicity, rethrowing the exception for now
            throw e;
        }
    
        // Return the deleted Need object
        return deleted;
    }

    /**
     * Gets all the needs from the cart.
     * 
     * @param need Need that is to be removed
     * @return list of needs 
     */
    public Need[] getNeeds() throws IOException {
        // Synchronize on the cart TreeMap to ensure thread safety
        synchronized(cart) {
            // Delegate to the method that retrieves an array of Need objects
            return getNeedsArray();
        }
    }
    
    /**
     * Remove all the needs from the cart.
     * 
     * @param
     * @return Boolean if needs are deleted
     */
    public boolean emptyNeeds() throws IOException {
        // Synchronize on the cart TreeMap to ensure thread safety
        synchronized(cart) {
            // Check if the cart is not empty
            if (cart.size() != 0) {
                // Reset the cart to an empty TreeMap
                
                // Persist the changes by saving to the file (may throw an IOException)
                save();
    
                // Return true indicating that the cart has been emptied
                return true;
            } else {
                // Return false indicating that the cart was already empty
                return false;
            }
        }
    }
}
