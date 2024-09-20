package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Season {
    @Id
    @GeneratedValue
    private int season_id;

    @Column
    private String season_name;

}
