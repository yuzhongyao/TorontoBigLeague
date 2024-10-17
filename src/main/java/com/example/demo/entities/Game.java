package com.example.demo.entities;


import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int game_id;

    @Column
    private short home_pts;

    @Column
    private short away_pts;

    @Column
    private LocalDate game_date;
    @Column
    private LocalTime game_time;

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

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session_id;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    public Game() {
    }

    public Session getSession_id() {
        return session_id;
    }

    public void setSession_id(Session session_id) {
        this.session_id = session_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public short getHome_pts() {
        return home_pts;
    }

    public void setHome_pts(short home_pts) {
        this.home_pts = home_pts;
    }

    public short getAway_pts() {
        return away_pts;
    }

    public void setAway_pts(short away_pts) {
        this.away_pts = away_pts;
    }

    public LocalDate getGame_date() {
        return game_date;
    }

    public void setGame_date(LocalDate game_date) {
        this.game_date = game_date;
    }

    public LocalTime getGame_time() {
        return game_time;
    }

    public void setGame_time(LocalTime game_time) {
        this.game_time = game_time;
    }

    public Team getHome_id() {
        return home_id;
    }

    public void setHome_id(Team home_id) {
        this.home_id = home_id;
    }

    public Team getAway_id() {
        return away_id;
    }

    public void setAway_id(Team away_id) {
        this.away_id = away_id;
    }

    public Age getAge_id() {
        return age_id;
    }

    public void setAge_id(Age age_id) {
        this.age_id = age_id;
    }

    public Location getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Location location_id) {
        this.location_id = location_id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}

