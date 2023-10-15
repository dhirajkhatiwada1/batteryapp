package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Battery {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String postcode;
    private double capacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double wattCapacity) {
        this.capacity = wattCapacity;
    }

    public Battery() {
    }

    public Battery(String name, String postcode, double capacity) {
        this.name = name;
        this.postcode = postcode;
        this.capacity = capacity;
    }


}

