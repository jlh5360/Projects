package com.ufund.api.ufundapi.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Need {

    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("cost") private double cost;
    @JsonProperty("amount") private int amount;
    @JsonProperty("description") private String description;

    // Remove the constructor with parameters
    // Use setters or fields to inject dependencies
    // Use @Value to specify default values
    // Use @Autowired to inject other beans
    public Need() {
        // Set some default values or leave them blank
        this.id = 0;
        this.name = "";
        this.cost = 0.0;
        this.amount = 0;
    }

    public Need(@JsonProperty("id") int id,
                     @JsonProperty("name") String name,
                     @JsonProperty("cost") double cost,
                     @JsonProperty("amount") int amount,
                     @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    // Use @Value to specify a default value for name
    @Value("")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    
    public double getCost() {
        return this.cost;
    }

    
    public void setCost(double cost) {
        this.cost = cost;
    }

    
    public int getAmount() {
        return this.amount;
    }

    
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", cost: " + cost + ", amount: " + amount + ", description: " + description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Need)) {
            return false;
        }
        Need need = (Need) obj;
        if (description != null) {
            return id == need.id 
                    && name.equals(need.name) 
                    && cost == need.cost 
                    && amount == need.amount 
                    && description.equals(need.description);

        } else {
            return id == need.id 
                    && name.equals(need.name) 
                    && cost == need.cost 
                    && amount == need.amount 
                    && description == need.description;

        }
    }

}

