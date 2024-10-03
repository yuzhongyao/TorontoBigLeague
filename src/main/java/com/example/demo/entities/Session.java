package com.example.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    private int session_id;

    @ManyToOne
    @JoinColumn(name = "age_id")
    private Age age;

    @Column
    private LocalDate session_date;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    public Session() {
    }



    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public LocalDate getSession_date() {
        return session_date;
    }

    public void setSession_date(LocalDate session_date) {
        this.session_date = session_date;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
