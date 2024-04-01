package com.ufund.api.ufundapi.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Elderly {

    @JsonProperty("id") private int id;
    @JsonProperty("name") private String name;
    @JsonProperty("age") private int age;
    @JsonProperty("gender") private String gender;
    @JsonProperty("level of up keep") private String lop;
    @JsonProperty("number of children") private int noc;
    @JsonProperty("description") private String description;

    // Remove the constructor with parameters
    // Use setters or fields to inject dependencies
    // Use @Value to specify default values
    // Use @Autowired to inject other beans
    public Elderly() {
        // Set some default values or leave them blank
        this.id = 0;
        this.name = "";
        this.age = 0;
        this.noc = 0; 
    }
    public Elderly(@JsonProperty("id") int id,
                        @JsonProperty("name") String name,
                        @JsonProperty("age") int age,
                        @JsonProperty("gender") String gender,
                        @JsonProperty("level of up keep") String lop,
                        @JsonProperty("number of children") int noc,
                        @JsonProperty("description") String description) {
                this.id = id;
                this.name = name;
                this.age = age;
                this.gender = gender;
                this.lop = lop;
                this.noc = noc;
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getLop(){
        return this.lop;
    }

    public void setLop(String lop){
        this.lop = lop;
    }
    
    public int getNoc(){
        return this.noc;
    }

    public void setNoc(int noc){
        this.noc = noc;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", age: " + age + ", gender: " + gender + ", level of up keep: " + lop + ", number of children: " + noc + ", description: " + description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Elderly)) {
            return false;
        }
        Elderly elderly = (Elderly) obj;
        if (description != null) {
            return id == elderly.id 
                    && name.equals(elderly.name) 
                    && age == elderly.age 
                    && gender == elderly.gender 
                    && lop == elderly.lop 
                    && noc == elderly.noc 
                    && description.equals(elderly.description);

        } else {
            return id == elderly.id 
                    && name.equals(elderly.name) 
                    && age == elderly.age 
                    && gender == elderly.gender 
                    && lop == elderly.lop 
                    && noc == elderly.noc 
                    && description == elderly.description;

        }
    }

}
