package com.example.demo.entities;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.Entity;
import jakarta.persistence.SqlResultSetMapping;


@SqlResultSetMapping(
        name = "TeamStandingMapping",
        columns = {
                @ColumnResult(name = "team_name", type = String.class),
                @ColumnResult(name = "games_played", type = Integer.class),
                @ColumnResult(name = "wins", type = Integer.class),
                @ColumnResult(name = "losses", type = Integer.class),
                @ColumnResult(name = "points_for", type = Integer.class),
                @ColumnResult(name = "points_against", type = Integer.class)
        }
)
public class TeamStanding {
    private String teamName;
    private long gamesPlayed;
    private long wins;
    private long losses;
    private long pointsFor;
    private long pointsAgainst;


    public TeamStanding(String teamName, long gamesPlayed, long wins, long losses, long pointsFor, long pointsAgainst) {
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.losses = losses;
        this.pointsFor = pointsFor;
        this.pointsAgainst = pointsAgainst;
    }

    // Getters and setters

    public double getWinPercentage(){

        if (this.gamesPlayed == 0) {
            return 0.0;
        }
        return (double) this.wins / this.gamesPlayed;

    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(long gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    public long getLosses() {
        return losses;
    }

    public void setLosses(long losses) {
        this.losses = losses;
    }

    public long getPointsFor() {
        return pointsFor;
    }

    public void setPointsFor(long pointsFor) {
        this.pointsFor = pointsFor;
    }

    public long getPointsAgainst() {
        return pointsAgainst;
    }

    public void setPointsAgainst(long pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }
}
