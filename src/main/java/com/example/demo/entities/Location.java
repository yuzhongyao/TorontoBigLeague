package com.example.demo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private int location_id;

    @Column
    private String location_name;

    @Column
    private String location_address;

}
