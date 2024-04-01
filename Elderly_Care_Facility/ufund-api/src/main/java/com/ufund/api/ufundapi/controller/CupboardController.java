package com.ufund.api.ufundapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ufund.api.ufundapi.model.Need;
import com.ufund.api.ufundapi.persistence.CupboardFileDAO;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("ufundapi")
public class CupboardController {

    private static final Logger LOG = Logger.getLogger(CupboardController.class.getName());
    private CupboardFileDAO cupboardDAO;

    public CupboardController(CupboardFileDAO cupboardDAO) {
        this.cupboardDAO = cupboardDAO;
    }

    /**
     * Creates a new need based on the need data that is attached to the post 
     * request. Returns success if completed request, or internal server error 
     * if failed to create need.
     *
     * @param need UFundNeed attached to body of post request
     */
    @PostMapping("needs")
    public ResponseEntity<Need> createNeed(@RequestBody Need need) {
        // Log the POST request for creating a new need
        LOG.info("POST /ufundapi/needs/");

        try {
            // Attempt to create a new need using the cupboardDAO
            Need createdNeed = this.cupboardDAO.createNeed(need);

            // Check if the need was successfully created
            if (createdNeed != null) {
                // Return a success response with the created need and HTTP status CREATED (201)
                return new ResponseEntity<Need>(createdNeed, HttpStatus.CREATED);
            } else {
                // Return a conflict response with HTTP status CONFLICT (409) if the creation was unsuccessful
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to the GET request for all {@linkplain Need needs} whose name contains
     * the text in name
     * 
     * @param name The name parameter which contains the text used to find the {@link Need needs}
     * 
     * @return ResponseEntity with array of {@link Need need} objects (may be empty) and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     * <p>
     * Example: Find all needs that contain the text "ma"
     * GET http://localhost:8080//ufundapi/search/needs/?name=ma
     */
    @GetMapping("search")
    public ResponseEntity<Need[]> searchNeeds(@RequestParam String name) {
        // Log the GET request for searching needs with the specified name
        LOG.info("GET /ufundapi/search/?name=" + name);

        try {
            // Attempt to search needs with the specified name using the cupboardDAO
            Need[] needs = cupboardDAO.searchNeeds(name);

            // Check if any needs were found
            if (needs.length != 0)
                // Return a success response with the array of needs and HTTP status OK (200)
                return new ResponseEntity<Need[]>(needs, HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404) if no needs were found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to the DELETE mapping for removing an items from the cupboard{@linkplain Need need}
     * 
     * @return ResponseEntity with HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
   @DeleteMapping("/needs/{id}")
    public ResponseEntity<Need> deleteNeed(@PathVariable int id) {
        // Log the DELETE request for deleting a need with the given ID
        LOG.info("POST /ufundapi/needs/");

        try {
            // Attempt to delete the need with the given ID using the cupboardDAO
            Need del_need = this.cupboardDAO.deleteNeed(id);

            // Check if the need was successfully deleted
            if (del_need != null)
                // Return a success response with HTTP status OK (200)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404) if the need was not found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to the GET request for a need by ID {@linkplain Int id}
     * 
     * @return ResponseEntity with a need {@link Need need} objects and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @GetMapping("needs/{id}")
    public ResponseEntity<Need> getNeedById(@PathVariable int id) {
        LOG.info("GET /ufundapi/needs/" + id);

        Need retrieveNeed = this.cupboardDAO.getNeed(id);
        if (retrieveNeed != null) {
            return new ResponseEntity<Need>(retrieveNeed, HttpStatus.OK);
        } else {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     /**
     * Responds to the PUT request for a need {@linkplain Need needs}
     * 
     * @return ResponseEntity with a need {@link Need need} objects and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @PutMapping("needs/{id}")
    public ResponseEntity<Need> updateNeed(@RequestBody Need need) {
        // Log the GET request for retrieving a need with the given ID
        LOG.info("PUT /ufundapi/needs/" + need);

        try{
            // Attempt to retrieve the need with the given ID using the cupboardDAO
            Need need2 = this.cupboardDAO.updateNeed(need);
            
            // Check if the need was successfully retrieved
            if (need2 != null)
                // Return a success response with the retrieved need and HTTP status OK (200)
                return new ResponseEntity<Need>(need2,HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404) if the need was not found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to the GET request for all {@linkplain Need needs}
     * 
     * @return ResponseEntity with array of {@link Need need} objects (may be empty) and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @GetMapping("all")
    public ResponseEntity<Need[]> getNeeds() {
        // Log the GET request for retrieving all needs
        LOG.info("GET /ufundapi/all");

        try {
            // Attempt to retrieve all needs using the cupboardDAO
            Need[] needs = cupboardDAO.getNeeds();

            // Check if needs were found
            if (needs != null)
                // Return a success response with the array of needs and HTTP status OK (200)
                return new ResponseEntity<Need[]>(needs, HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404) if the need was not found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Placeholder or unused method; consider removing or providing a proper implementation
    public ResponseEntity<Need[]> assertEquals(HttpStatus ok, HttpStatus statusCode) {
        return null;
    }
}
