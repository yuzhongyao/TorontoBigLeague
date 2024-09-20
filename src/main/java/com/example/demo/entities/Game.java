package com.example.demo.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private int game_id;

    @Column
    private short home_pts;

    @Column
    private short away_pts;

    @Column
    private LocalDate game_date;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Team home_id;

    @ManyToOne
    @JoinColumn(name = "away_id")
    private Team away_id;

    @ManyToOne
    @JoinColumn(name = "age_id")
    private Age age_id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location_id;
}
