package com.ufund.api.ufundapi.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("password") private String password;
    @JsonProperty("admin") private Boolean admin;
    @JsonProperty("adoptedElderly") private Elderly[] adoptedElderly;
    @JsonProperty("cart") private Need[] cart;

    public User(@JsonProperty("id") int id, 
                @JsonProperty("name") String name, 
                @JsonProperty("password") String password,
                @JsonProperty("admin") Boolean admin,
                @JsonProperty("adoptedElderly") Elderly[] adoptedElderly,
                @JsonProperty("cart") Need[] cart
                ) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.admin = admin;
        this.adoptedElderly = adoptedElderly;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isAdmin() {
        return this.admin;
    }

    public Need[] getCart() {
        return this.cart;
    }

    public void setCart(Need[] cart) {
        this.cart = cart;
    }


    public Elderly[] getAdoptedElderly() {
        return this.adoptedElderly;
    }

    // Not needed right now.

    // public void addAdoptedElderly(Elderly elder) {
        // ArrayList<Elderly> elders = new ArrayList<>();
        // for (int i = 0; i < adoptedElderly.length; i++) {
            // elders.add(adoptedElderly[i]);
        // }
        // elders.add(elder);
        // Elderly[] newElderlyArray = new Elderly[elders.size()];
        // elders.toArray(newElderlyArray);
        // this.adoptedElderly = newElderlyArray;
    // }

    // public boolean removeAdoptedElderly(Elderly elder) {
        // ArrayList<Elderly> elders = new ArrayList<>();
        // for (int i = 0; i < adoptedElderly.length; i++) {
            // elders.add(adoptedElderly[i]);
        // }

        // boolean result = elders.remove(elder);
        // Elderly[] newElderlyArray = new Elderly[elders.size()];
        // elders.toArray(newElderlyArray);
        // this.adoptedElderly = newElderlyArray;
        // return result;
    // }

    @Override
    public boolean equals(Object object) {

        User user = null;

        if (object instanceof User) {
            user = (User) object;
        } else {
            return false;
        }

        return user.name.equals(this.name) &&
               user.password.equals(this.password
               // && user.adoptedElderly.equals(this.adoptedElderly)
               );
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.password.hashCode() + this.id * 7;
    }

}
