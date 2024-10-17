package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ages")
public class Age {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int age_id;

    @Column
    private String age_group;

    public Age() {
    }

    public int getAge_id() {
        return age_id;
    }

    public void setAge_id(int age_id) {
        this.age_id = age_id;
    }

    public String getAge_group() {
        return age_group;
    }

    public void setAge_group(String age_group) {
        this.age_group = age_group;
    }
}
