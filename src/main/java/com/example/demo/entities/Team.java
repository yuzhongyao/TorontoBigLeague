package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue
    private int team_id;

    @Column
    private String team_name;

    @ManyToOne
    @JoinColumn(name = "age_id")
    private Age age;


}
