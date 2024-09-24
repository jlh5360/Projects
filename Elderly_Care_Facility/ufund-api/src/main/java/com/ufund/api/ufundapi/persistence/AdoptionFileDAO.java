package com.ufund.api.ufundapi.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufund.api.ufundapi.model.Elderly;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;

@Component
public class AdoptionFileDAO {

    Map<Integer, Elderly> adoption;

    private static int nextId;
    private String filename;
    private ObjectMapper objectMapper;

    // Constructor for AdoptionFileDAO class
    public AdoptionFileDAO(@Value("data/adoption.json") String filename, 
    ObjectMapper objectMapper) throws IOException {
        // Initialize instance variables with provided values
        this.filename = filename;
        this.objectMapper = objectMapper;

        // Load data from the specified file
        load();

        // Print a message indicating successful loading of test adoption data (for debugging or informational purposes)
        System.out.println("Successfully loaded first test need data:\n " +adoption.get(1) + " \n\n");
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
    
    // A convenience method to get an array of Elderly objects with optional filtering
    private Elderly[] getElderliesArray() {
        // Delegate to the overloaded method with null as the filter
        return getElderliesArray(null);
    }

    /**
     * Retrieve an array of Elderly objects with optional text filtering
     *
     * @return an array of elderlies
     */
    private Elderly[] getElderliesArray(String containsText) {
        // Create an ArrayList to store filtered Elderly objects
        ArrayList<Elderly> elderlyArrayList = new ArrayList<>();

        // Iterate over all Elderly objects in the adoption map
        for (Elderly elder : adoption.values()) {
            // Check if the Elderly object matches the filter criteria
            if (containsText == null || elder.getName().contains(containsText)) {
                // Add the Elderly object to the filtered list
                elderlyArrayList.add(elder);
            }
        }

        // Convert the ArrayList to an array and return it
        Elderly[] elderliesArray = new Elderly[elderlyArrayList.size()];
        elderlyArrayList.toArray(elderliesArray);
        return elderliesArray;
    }

    /**
     * Saves current list of elderlies to a json file on the local system.
     *
     * @return True if succeeded
     * @throws IOException Throws if failed to save
     */
    private boolean save() throws IOException {
        // Check if ObjectMapper is not configured
        if (objectMapper == null) {
            return false;
        }
        // Check if the filename is set to "doNotSave," indicating that saving is not required
        if ((filename != null) && (filename.equals("doNotSave"))){
            return true;
        }
        // Retrieve an array of Elderly objects
        Elderly[] elderliesArray = getElderliesArray();

         // Write the Elderly array to the specified file using the ObjectMapper
        objectMapper.writeValue(new File(filename), elderliesArray);

        // Save operation completed successfully
        return true;
    }

    /**
     * Loads the list of elderlies from a local json file.
     *
     * @return True if succeeded in loading in elderlies from file
     * @throws IOException Throws if failed in loading from file
     */
    private boolean load() throws IOException {
        // Initialize the adoption TreeMap and reset the nextId counter
        adoption = new TreeMap<>();
        nextId = 1;

        // Check if ObjectMapper is not configured
        if (objectMapper == null) {
            return false;
        }

        // Check if the filename is set to "doNotSave"
        if ((filename != null) && (filename.equals("doNotSave"))) {
            // Skip loading if the filename is set to "doNotSave"
            return true;
        }

        // Initialize the adoption TreeMap and reset the nextId counter
        adoption = new TreeMap<>();
        nextId = 1;

        // Read Elderly array from the specified file using the ObjectMapper
        Elderly[] elderlyArray = objectMapper.readValue(new File(filename), Elderly[].class);

        // Populate the adoption TreeMap with Elderly objects and update the nextId counter
        for (Elderly elder : elderlyArray) {
            adoption.put(elder.getId(), elder);

            // Update the nextId counter based on the maximum Elderly ID in the loaded data
            if (elder.getId() > nextId) {
                nextId = elder.getId();
            }
        }
        // Increment the nextId counter to ensure uniqueness for future IDs
        ++nextId;

        // Load operation completed successfully
        return true;
    }

    /**
     * Add a elder into the elderly list 
     * 
     * @param elder Elderly that is to be added
     * @return The elder that was added
     */
    public Elderly addElderly(Elderly elder) throws IOException {
        Elderly newElder = new Elderly(nextId(), 
                                          elder.getName(), 
                                          elder.getAge(), 
                                          elder.getGender(),
                                          elder.getLop(),
                                          elder.getNoc(),
                                          elder.getDescription());
        adoption.put(newElder.getId(), newElder);
        save();
        return newElder;
    }

    /**
     * Gets all the elderlies from the adoption ceneter.
     * 
     * @param Elderly elder that is to be removed
     * @return The need that was deleted
     */
    public Elderly[] getElderlies() throws IOException {
        synchronized(adoption) {
            return getElderliesArray();
        }
    }
    
    public Elderly removeElderly(int id) throws IOException {
        // Remove the Elderly with the specified ID from the adoption TreeMap
        Elderly deleted = adoption.remove(id);

        // Persist the changes by saving to the file (may throw an IOException)
        save();

        // Return the deleted Elderly object
        return deleted;
    }

    public Elderly updateElderly(Elderly elder) throws IOException {
        synchronized(adoption) {
            // Check if the Elderly has a valid ID
            if (elder.getId() == 0){
                // Return null if the ID is invalid
                return null;
            } 

            // Check if the Elderly with the given ID exists in the adoption TreeMap
            if (adoption.containsKey(elder.getId()) == false)
                // Return null if the Elderly does not exist
                return null;

            // Update the Elderly information in the adoption TreeMap
            adoption.put(elder.getId(),elder);
            save(); // may throw an IOException
            return elder;
        }
    }
}

