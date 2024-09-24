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

/**
 * Note: There is no instantiation of this class due to how Spring works. The
 * framework automatically instantiates it for us for use elsewhere.
 *
 * Class to be used to interact with the persistent file storage json file.
 *
 */
@Component
public class CupboardFileDAO {

    Map<Integer, Need> needs;

    private static int nextId;
    private String filename;
    private ObjectMapper objectMapper;
    
    // Constructor for CupboardFileDAO class
    public CupboardFileDAO(@Value("data/needs.json") String filename, ObjectMapper objectMapper) throws IOException {
        // Initialize the filename and objectMapper
        this.filename = filename;
        this.objectMapper = objectMapper;

        // Load data from the specified file
        load();
        // System.out.println("Successfully loaded first test need data:\n " +
                // needs.get(1) + " \n\n");
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
    
        // Iterate over all Need objects in the needs map
        for (Need need : needs.values()) {
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
        // Initialize the needs TreeMap and reset the nextId counter
        needs = new TreeMap<>();
        nextId = 1;

        // Check if ObjectMapper is not configured
        if (objectMapper == null) {
            // Data is considered loaded if ObjectMapper is not configured
            return true;
        }

        // Check if the filename is set to "doNotSave"
        if ((filename != null) && (filename.equals("doNotSave"))) {
            // Data is considered loaded if the filename is set to "doNotSave"
            return true;
        }

        // Read Need array from the specified file using the ObjectMapper
        Need[] needArray = objectMapper.readValue(new File(filename), Need[].class);

        // Populate the needs TreeMap with Need objects and update the nextId counter
        for (Need need : needArray) {
            needs.put(need.getId(), need);

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
     * Creates a new need and addes it to the list of needs, and saves the 
     * updated list to the file for persistence.
     *
     * @param name Name of need
     * @param cost Cost of need
     * @param amount Amound of need in stock
     * @return Newly created need
     * @throws IOException Throws if failed to save to local file
     */
    public Need createNeed(Need need) throws IOException {
        Need newNeed = new Need(nextId(), 
                                          need.getName(), 
                                          need.getCost(), 
                                          need.getAmount(),
                                          need.getDescription());
        needs.put(newNeed.getId(), newNeed);
        // if (newNeed.getId() > nextId) {
        //     nextId = newNeed.getId();
        // }

        save();
        return newNeed;
    }

    public Need getNeed(int id) {
        return needs.get(id);
    }

    /**
     * Deletes a need from the list of needs.
     * 
     * @param id Need to be deleted
     * @return Need that is being deleted
     * @throws IOException If failed to save to local file
     */
    public Need deleteNeed(int id) throws IOException {
        Need deleted = needs.remove(id);
        save();
        return deleted;
    }

    /**
     * Gets all the needs from the cupboard.
     * 
     * @throws IOException If failed to get from local file
     * @return All the needs from the cupboard
     */
    public Need[] getNeeds() throws IOException {
        synchronized(needs) {
            return getNeedsArray();
        }
    }

    /**
     * Searches/finds the needs in the cupboard whose name contains
     * the given text and will only show that subset of needs.
     * 
     * @param containsText The text contained inside of the need
     * @return The subset of that specific needs that contains the text
     */
    public Need[] searchNeeds(String containsText) throws IOException {
        // Synchronize on the needs TreeMap to ensure thread safety
        synchronized(needs) {
            // Delegate to the method that retrieves an array of Need objects with optional text filtering
            return getNeedsArray(containsText);
        }
    }
    
    /**
     * Update a Need and persist the changes
     * 
     * @param Need need
     * @return the newly updated need
     */
    public Need updateNeed(Need need) throws IOException {
        // Synchronize on the needs TreeMap to ensure thread safety
        synchronized(needs) {
            if (need.getId() == 0){
                // Return null if the ID is invalid
                return null;
            } 
            
            // Check if the Need with the provided ID exists
            if (needs.containsKey(need.getId()) == false){
                return null;  // need does not exist
            }

            // Update the Need in the needs TreeMap
            needs.put(need.getId(),need);

            // Persist the changes by saving to the file (may throw an IOException)
            save(); // may throw an IOException

            // Return the updated Need
            return need;
        }
    }

}
