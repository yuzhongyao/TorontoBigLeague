package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ages")
public class Age {

    @Id
    @GeneratedValue
    private int age_id;

    @Column
    private String age_group;
}
