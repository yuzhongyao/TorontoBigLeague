package com.example.demo.repositories;

import com.example.demo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Game, Integer> {


    @Query(nativeQuery = true, value = "SELECT \n" +
            "    g.game_id,\n" +
            "    g.home_pts,\n" +
            "    g.away_pts,\n" +
            "    g.game_date,\n" +
            "    g.game_time,\n" +
            "    home.team_name AS home_team,\n" +
            "    away.team_name AS away_team,\n" +
            "    a.age_group,\n" +
            "    l.location_name,\n" +
            "    l.location_address\n" +
            "FROM games g\n" +
            "JOIN teams home ON g.home_id = home.team_id\n" +
            "JOIN teams away ON g.away_id = away.team_id\n" +
            "JOIN ages a ON g.age_id = a.age_id\n" +
            "JOIN locations l ON g.location_id = l.location_id\n" +
            "JOIN seasons s ON s.season_id = g.season_id\n"+
            "WHERE s.season_id = (SELECT MAX(season_id) FROM seasons)\n" +
            "ORDER BY g.game_date ASC\n")
    List<Game> getCurrentSeasonGames();

    @Query(value = "select * from games where age_id = :ageId", nativeQuery = true)
    List<Game> getGamesByAge(@Param("ageId") int ageId);

}
