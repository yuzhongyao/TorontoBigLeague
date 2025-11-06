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

    //CHECK age id of "SR" Age group

    @Query(value = "select * from games where (age_id = 7 or age_id = 9 or age_id = 35) " +
            "AND games.game_date < CURRENT_DATE - INTERVAL '3 day' " +
            "ORDER BY games.game_date, games.game_time", nativeQuery = true)
    List<Game> getPastSrGames();

    //CHECK age id of "JR" Age group
    @Query(value = "select * from games where (age_id = 6 or age_id = 8 or age_id = 34) " +
            "AND games.game_date < CURRENT_DATE - INTERVAL '3 day' " +
            "ORDER BY games.game_date, games.game_time", nativeQuery = true)
    List<Game> getPastJrGames();


    //CHECK age id of "SR" Age group
    @Query(value = "select * from games where (age_id = 7 or age_id = 9 or age_id = 35) " +
            "AND games.game_date >= CURRENT_DATE - INTERVAL '3 day' " +
            "ORDER BY games.game_date, games.game_time", nativeQuery = true)
    List<Game> getSrUpcomingGames();

    //CHECK age id of "JR" Age group
    @Query(value = "select * from games where (age_id = 6 or age_id = 8 or age_id = 34) " +
            "AND games.game_date >= CURRENT_DATE - INTERVAL '3 day' " +
            "ORDER BY games.game_date, games.game_time", nativeQuery = true)
    List<Game> getJrUpcomingGames();

    @Query(value = "select * from games where age_id = :ageId " +
            "AND games.game_date < CURRENT_DATE - INTERVAL '3 day' " +
            "ORDER BY games.game_date, games.game_time", nativeQuery = true)
    List<Game> getPastGamesByAge(@Param("ageId") int ageId);
    @Query(value = "select * from games where age_id = :ageId " +
            "AND games.game_date >= CURRENT_DATE - INTERVAL '3 day' " +
            "ORDER BY games.game_date, games.game_time", nativeQuery = true)
    List<Game> getUpcomingGamesByAge(@Param("ageId") int ageId);

}
