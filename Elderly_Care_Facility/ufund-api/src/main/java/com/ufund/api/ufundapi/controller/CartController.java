package com.ufund.api.ufundapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ufund.api.ufundapi.model.Elderly;
import com.ufund.api.ufundapi.model.Need;
import com.ufund.api.ufundapi.persistence.CartFileDAO;


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
@RequestMapping("ufundapi")
public class CartController {
    private static final Logger LOG = Logger.getLogger(CartController.class.getName());
    private CartFileDAO cartDAO;

    public CartController(CartFileDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    /**
     * Responds to the POST mapping for adding a new need {@linkplain Need need}
     * 
     * @return ResponseEntity with an {@link Need need} object and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @PostMapping("/cart/needs")
    public ResponseEntity<Need> addItem(@RequestBody Need need) {
        // Log the POST request for adding an item to the cart
        LOG.info("POST /ufundapi/cart/needs/");

        try {
            // Attempt to add the item (Need) to the cart using the cartDAO
            Need addedNeed = this.cartDAO.addItem(need);

            // Check if the item was successfully added to the cart
            if (addedNeed != null) {
                // Return a success response with the added item and HTTP status CREATED (201)
                return new ResponseEntity<Need>(addedNeed, HttpStatus.CREATED);
            } else {
                // Return a conflict response with HTTP status CONFLICT (409) if the addition was unsuccessful// Return a conflict response with HTTP status CONFLICT (409) if the addition was unsuccessful
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } catch (IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
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
    @GetMapping("cart/all")
    public ResponseEntity<Need[]> getNeeds() {
        // Log the GET request for retrieving all items from the cart
        LOG.info("GET /ufundapi/all");

        try {
            // Attempt to get all items (Needs) from the cart using the cartDAO
            Need[] needs = cartDAO.getNeeds();

            // Check if items were found in the cart
            if (needs != null)
                // Return a success response with the array of items and HTTP status OK (200)
                return new ResponseEntity<Need[]>(needs, HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404) if no items were found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to the DELETE mapping for removing an item from the cart by ID {@linkplain Int id}
     * 
     * @return ResponseEntity with  HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @DeleteMapping("/cart/needs/{id}")
    public ResponseEntity<Need> removeItem(@PathVariable int id) {
        // Log the DELETE request for removing an item from the cart with the given ID
        LOG.info("DELETE /ufundapi/cart/needs/"+id);
        try {
            // Attempt to remove the item (Need) from the cart using the cartDAO
            Need del_need = this.cartDAO.removeItem(id);

            // Check if the item was successfully removed
            if (del_need != null)
                // Return a success response with HTTP status OK (200)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                // Return a not found response with HTTP status NOT FOUND (404) if the item was not found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Need[]> assertEquals(HttpStatus ok, HttpStatus statusCode) {
        // Use assertEquals from your testing framework (JUnit) to compare HttpStatus values
        return null;
    }
    
    /**
     * Responds to the DELETE mapping for removing all items from the cart{@linkplain Need needs}
     * 
     * @return ResponseEntity with array of {@link Need need} objects (may be empty) and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @DeleteMapping("cart/needs")
    public ResponseEntity<Need[]> clearCart() {
        // Log the DELETE request for clearing all items from the cart
        LOG.info("DELETE /ufundapi/all");

        try{
            // Attempt to clear all items from the cart using the cartDAO
            boolean boo = cartDAO.emptyNeeds();
            Need[] needs = cartDAO.getNeeds();
            
            // Check if the cart was successfully cleared
            if (boo == true)
                // Return a success response with the array of items and HTTP status OK (200)
                return new ResponseEntity<Need[]>(needs,HttpStatus.OK);
            else
                // Return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        catch(IOException e) {
            // Log and return an internal server error response with HTTP status INTERNAL SERVER ERROR (500)
            LOG.log(Level.SEVERE,e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}