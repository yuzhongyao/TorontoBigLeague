package com.example.demo.repositories;

import com.example.demo.entities.Team;
import com.example.demo.entities.TeamStanding;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamsRepository extends JpaRepository<Team, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM teams WHERE " +
            "teams.age_id = :ageId ")
    List<Team> findAllByAgeGroup(@Param("ageId") int ageId);

    @Query(nativeQuery = true, value = "SELECT * FROM teams WHERE " +
            "teams.age_id = 7 OR teams.age_id = 9")
    List<Team> findAllSenior();

    @Query(nativeQuery = true, value = "SELECT * FROM teams WHERE " +
            "teams.age_id = 6 OR teams.age_id = 8")
    List<Team> findAllJunior();

    @Query(nativeQuery = true, value = "SELECT t.team_name, COUNT(g.game_id) AS games_played, " +
            "SUM(CASE WHEN t.team_id = g.home_id AND g.home_pts > g.away_pts THEN 1 " +
            "WHEN t.team_id = g.away_id AND g.away_pts > g.home_pts THEN 1 ELSE 0 END) AS wins, " +
            "SUM(CASE WHEN t.team_id = g.home_id AND g.home_pts < g.away_pts THEN 1 " +
            "WHEN t.team_id = g.away_id AND g.away_pts < g.home_pts THEN 1 ELSE 0 END) AS losses, " +
            "SUM(CASE WHEN t.team_id = g.home_id THEN g.home_pts ELSE g.away_pts END) AS points_for, " +
            "SUM(CASE WHEN t.team_id = g.home_id THEN g.away_pts ELSE g.home_pts END) AS points_against " +
            "FROM teams t " +
            "LEFT JOIN games g ON t.team_id = g.home_id OR t.team_id = g.away_id " +
            "JOIN ages a ON t.age_id = a.age_id " +
            "WHERE a.age_group = :ageGroup " +
            "GROUP BY t.team_name " +
            "ORDER BY wins DESC, points_for DESC, points_against ASC")
    List<Tuple> findTeamStandingsByAgeGroup(@Param("ageGroup") String ageGroup);



    //    @Query(nativeQuery = true, value = "SELECT\n" +
//            "    t.team_name,\n" +
//            "    COUNT(g.game_id) AS games_played, \n" +
//            "    SUM(CASE \n" +
//            "            WHEN t.team_id = g.home_id AND g.home_pts > g.away_pts THEN 1 \n" +
//            "            WHEN t.team_id = g.away_id AND g.away_pts > g.home_pts THEN 1 \n" +
//            "            ELSE 0 \n" +
//            "        END) AS wins,\n" +
//            "    SUM(CASE \n" +
//            "            WHEN t.team_id = g.home_id AND g.home_pts < g.away_pts THEN 1 \n" +
//            "            WHEN t.team_id = g.away_id AND g.away_pts < g.home_pts THEN 1 \n" +
//            "            ELSE 0 \n" +
//            "        END) AS losses,\n" +
//            "    SUM(CASE \n" +
//            "            WHEN t.team_id = g.home_id THEN g.home_pts \n" +
//            "            ELSE g.away_pts \n" +
//            "        END) AS points_for,\n" +
//            "    SUM(CASE \n" +
//            "            WHEN t.team_id = g.home_id THEN g.away_pts \n" +
//            "            ELSE g.home_pts \n" +
//            "        END) AS points_against\n" +
//            "FROM \n" +
//            "    teams t\n" +
//            "JOIN \n" +
//            "    games g ON t.team_id = g.home_id OR t.team_id = g.away_id\n" +
//            "JOIN \n" +
//            "    ages a ON t.age_id = a.age_id\n" +
//            "WHERE \n" +
//            "    a.age_group = 'Grade 8'\n" +
//            "GROUP BY \n" +
//            "    t.team_name\n" +
//            "ORDER BY \n" +
//            "    wins DESC, -- Teams with more wins are ranked higher\n" +
//            "    points_for DESC, -- In case of tie, teams with more points scored rank higher\n" +
//            "    points_against ASC; -- In case of further tie, fewer points conceded rank higher")
//    List<Object[]> findGrade8TeamStandings();
@Query(nativeQuery = true, value = "SELECT\n" +
        "    t.team_name,\n" +
        "    COUNT(g.game_id) AS games_played, \n" +
        "    SUM(CASE \n" +
        "            WHEN t.team_id = g.home_id AND g.home_pts > g.away_pts THEN 1 \n" +
        "            WHEN t.team_id = g.away_id AND g.away_pts > g.home_pts THEN 1 \n" +
        "            ELSE 0 \n" +
        "        END) AS wins,\n" +
        "    SUM(CASE \n" +
        "            WHEN t.team_id = g.home_id AND g.home_pts < g.away_pts THEN 1 \n" +
        "            WHEN t.team_id = g.away_id AND g.away_pts < g.home_pts THEN 1 \n" +
        "            ELSE 0 \n" +
        "        END) AS losses,\n" +
        "    SUM(CASE \n" +
        "            WHEN t.team_id = g.home_id THEN g.home_pts \n" +
        "            ELSE g.away_pts \n" +
        "        END) AS points_for,\n" +
        "    SUM(CASE \n" +
        "            WHEN t.team_id = g.home_id THEN g.away_pts \n" +
        "            ELSE g.home_pts \n" +
        "        END) AS points_against\n" +
        "FROM \n" +
        "    teams t\n" +
        "JOIN \n" +
        "    games g ON t.team_id = g.home_id OR t.team_id = g.away_id\n" +
        "JOIN \n" +
        "    ages a ON t.age_id = a.age_id\n" +
        "WHERE \n" +
        "    a.age_group = 'Grade 8'\n" +
        "GROUP BY \n" +
        "    t.team_name\n" +
        "ORDER BY \n" +
        "    wins DESC, -- Teams with more wins are ranked higher\n" +
        "    points_for DESC, -- In case of tie, teams with more points scored rank higher\n" +
        "    points_against ASC; -- In case of further tie, fewer points conceded rank higher")
List<TeamStanding> findGrade8TeamStandings();


    @Query(nativeQuery = true, value = "SELECT\n" +
            "    t.team_name,\n" +
            "    COUNT(g.game_id) AS games_played, \n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id AND g.home_pts > g.away_pts THEN 1 \n" +
            "            WHEN t.team_id = g.away_id AND g.away_pts > g.home_pts THEN 1 \n" +
            "            ELSE 0 \n" +
            "        END) AS wins,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id AND g.home_pts < g.away_pts THEN 1 \n" +
            "            WHEN t.team_id = g.away_id AND g.away_pts < g.home_pts THEN 1 \n" +
            "            ELSE 0 \n" +
            "        END) AS losses,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id THEN g.home_pts \n" +
            "            ELSE g.away_pts \n" +
            "        END) AS points_for,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id THEN g.away_pts \n" +
            "            ELSE g.home_pts \n" +
            "        END) AS points_against\n" +
            "FROM \n" +
            "    teams t\n" +
            "JOIN \n" +
            "    games g ON t.team_id = g.home_id OR t.team_id = g.away_id\n" +
            "JOIN \n" +
            "    ages a ON t.age_id = a.age_id\n" +
            "WHERE \n" +
            "    a.age_group = 'Jr Rep'\n" +
            "GROUP BY \n" +
            "    t.team_name\n" +
            "ORDER BY \n" +
            "    wins DESC, -- Teams with more wins are ranked higher\n" +
            "    points_for DESC, -- In case of tie, teams with more points scored rank higher\n" +
            "    points_against ASC; -- In case of further tie, fewer points conceded rank higher")
    List<TeamStanding> findJrRepStandings();

    @Query(nativeQuery = true, value = "SELECT\n" +
            "    t.team_name,\n" +
            "    COUNT(g.game_id) AS games_played, \n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id AND g.home_pts > g.away_pts THEN 1 \n" +
            "            WHEN t.team_id = g.away_id AND g.away_pts > g.home_pts THEN 1 \n" +
            "            ELSE 0 \n" +
            "        END) AS wins,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id AND g.home_pts < g.away_pts THEN 1 \n" +
            "            WHEN t.team_id = g.away_id AND g.away_pts < g.home_pts THEN 1 \n" +
            "            ELSE 0 \n" +
            "        END) AS losses,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id THEN g.home_pts \n" +
            "            ELSE g.away_pts \n" +
            "        END) AS points_for,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id THEN g.away_pts \n" +
            "            ELSE g.home_pts \n" +
            "        END) AS points_against\n" +
            "FROM \n" +
            "    teams t\n" +
            "JOIN \n" +
            "    games g ON t.team_id = g.home_id OR t.team_id = g.away_id\n" +
            "JOIN \n" +
            "    ages a ON t.age_id = a.age_id\n" +
            "WHERE \n" +
            "    a.age_group = 'Sr Rep'\n" +
            "GROUP BY \n" +
            "    t.team_name\n" +
            "ORDER BY \n" +
            "    wins DESC, -- Teams with more wins are ranked higher\n" +
            "    points_for DESC, -- In case of tie, teams with more points scored rank higher\n" +
            "    points_against ASC; -- In case of further tie, fewer points conceded rank higher")
    List<TeamStanding> findSrRepStandings();

    @Query(nativeQuery = true, value = "SELECT\n" +
            "    t.team_name,\n" +
            "    COUNT(g.game_id) AS games_played, \n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id AND g.home_pts > g.away_pts THEN 1 \n" +
            "            WHEN t.team_id = g.away_id AND g.away_pts > g.home_pts THEN 1 \n" +
            "            ELSE 0 \n" +
            "        END) AS wins,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id AND g.home_pts < g.away_pts THEN 1 \n" +
            "            WHEN t.team_id = g.away_id AND g.away_pts < g.home_pts THEN 1 \n" +
            "            ELSE 0 \n" +
            "        END) AS losses,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id THEN g.home_pts \n" +
            "            ELSE g.away_pts \n" +
            "        END) AS points_for,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id THEN g.away_pts \n" +
            "            ELSE g.home_pts \n" +
            "        END) AS points_against\n" +
            "FROM \n" +
            "    teams t\n" +
            "JOIN \n" +
            "    games g ON t.team_id = g.home_id OR t.team_id = g.away_id\n" +
            "JOIN \n" +
            "    ages a ON t.age_id = a.age_id\n" +
            "WHERE \n" +
            "    a.age_group = 'Jr Prep'\n" +
            "GROUP BY \n" +
            "    t.team_name\n" +
            "ORDER BY \n" +
            "    wins DESC, -- Teams with more wins are ranked higher\n" +
            "    points_for DESC, -- In case of tie, teams with more points scored rank higher\n" +
            "    points_against ASC; -- In case of further tie, fewer points conceded rank higher")
    List<TeamStanding> findJrPrepStandings();

    @Query(nativeQuery = true, value = "SELECT\n" +
            "    t.team_name,\n" +
            "    COUNT(g.game_id) AS games_played, \n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id AND g.home_pts > g.away_pts THEN 1 \n" +
            "            WHEN t.team_id = g.away_id AND g.away_pts > g.home_pts THEN 1 \n" +
            "            ELSE 0 \n" +
            "        END) AS wins,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id AND g.home_pts < g.away_pts THEN 1 \n" +
            "            WHEN t.team_id = g.away_id AND g.away_pts < g.home_pts THEN 1 \n" +
            "            ELSE 0 \n" +
            "        END) AS losses,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id THEN g.home_pts \n" +
            "            ELSE g.away_pts \n" +
            "        END) AS points_for,\n" +
            "    SUM(CASE \n" +
            "            WHEN t.team_id = g.home_id THEN g.away_pts \n" +
            "            ELSE g.home_pts \n" +
            "        END) AS points_against\n" +
            "FROM \n" +
            "    teams t\n" +
            "JOIN \n" +
            "    games g ON t.team_id = g.home_id OR t.team_id = g.away_id\n" +
            "JOIN \n" +
            "    ages a ON t.age_id = a.age_id\n" +
            "WHERE \n" +
            "    a.age_group = 'Sr Prep'\n" +
            "GROUP BY \n" +
            "    t.team_name\n" +
            "ORDER BY \n" +
            "    wins DESC, -- Teams with more wins are ranked higher\n" +
            "    points_for DESC, -- In case of tie, teams with more points scored rank higher\n" +
            "    points_against ASC; -- In case of further tie, fewer points conceded rank higher")
    List<TeamStanding> findSrPrepStandings();
}
