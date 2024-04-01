package com.ufund.api.ufundapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ufund.api.ufundapi.model.Elderly;
import com.ufund.api.ufundapi.persistence.AdoptionFileDAO;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("ufundapi/adoption")
public class AdoptionController {
    private static final Logger LOG = Logger.getLogger(AdoptionController.class.getName());
    private AdoptionFileDAO adoptionDAO;

    public AdoptionController(AdoptionFileDAO adoptionDAO){
        this.adoptionDAO = adoptionDAO;
    }

    /**
     * Responds to the POST mapping for adding a new elderly person {@linkplain Elderly elder}
     * 
     * @return ResponseEntity with an {@link Elderly elder} object and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @PostMapping("/elderly")
    public ResponseEntity<Elderly> addElderly(@RequestBody Elderly elder) {
        // Log the POST request for adding a new elderly person
        LOG.info("POST /ufundapi/adoption/elderly/");

        try {
            // Attempt to add the new elderly person using the adoptionDAO
            Elderly addedElder = this.adoptionDAO.addElderly(elder);

            // Check if the new elderly person was successfully added
            if (addedElder != null) {
                // Return a success response with the added elderly person and HTTP status CREATED (201)
                return new ResponseEntity<Elderly>(addedElder, HttpStatus.CREATED);
            } else {
                // Return a conflict response with HTTP status CONFLICT (409) if the addition was unsuccessful
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to the GET request for all {@linkplain Elderly elders}
     * 
     * @return ResponseEntity with array of {@link Elderly elder} objects (may be empty) and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @GetMapping("all")
    public ResponseEntity<Elderly[]> getElderlies() {
        // Log the GET request for retrieving all elderly persons
        LOG.info("GET /ufundapi/adoption/all");

        try {
            // Attempt to get all elderly persons from the adoptionDAO
            Elderly[] elder = adoptionDAO.getElderlies();
            
            // Check if elderly persons were found
            if (elder != null)
                // Return a success response with the array of elderly persons and HTTP status OK (200)
                return new ResponseEntity<Elderly[]>(elder, HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to DELETE mapping for removing an elderly person by ID {@linkplain Int id}
     * 
     * @return ResponseEntity HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @DeleteMapping("/elderly/{id}")
    public ResponseEntity<Elderly> removeElderly(@PathVariable int id) {
        // Log the DELETE request with the ID
        LOG.info("DELETE /ufundapi/adoption/elderly"+id);
        try {
            // Attempt to remove the elderly person with the given ID using the adoptionDAO
            Elderly del_elder = this.adoptionDAO.removeElderly(id);

            // Check if the elderly person was successfully removed
            if (del_elder != null)
                // Return a success response with HTTP status OK (200)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to PUT mapping for updating an elderly person {@linkplain Elderly elder}
     * 
     * @return ResponseEntity with an {@link Elderly elder} object and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @PutMapping("/elderly/{id}")
    public ResponseEntity<Elderly> updateElderly(@RequestBody Elderly elder) {
        // Log the PUT request for updating an existing elderly person with the given ID
        LOG.info("PUT /ufundapi/adoption/elderly/" + elder);

        try{
            // Attempt to update the existing elderly person using the adoptionDAO
            Elderly elder2 = this.adoptionDAO.updateElderly(elder);

            // Check if the elderly person was successfully updated
            if (elder2 != null)
                // Return a success response with the updated elderly person and HTTP status OK (200)
                return new ResponseEntity<Elderly>(elder2,HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404) if the elderly person was not found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
