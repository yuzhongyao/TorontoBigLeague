package com.example.demo.services;

import com.example.demo.entities.Age;
import com.example.demo.entities.Team;
import com.example.demo.entities.TeamStanding;
import com.example.demo.repositories.TeamsRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamsService {

    private final TeamsRepository teamsRepository;

    @Autowired
    public TeamsService(TeamsRepository teamsRepository){
        this.teamsRepository = teamsRepository;
    }

    public Optional<Team> findTeamById(int id){
        return teamsRepository.findById(id);
    }

    public List<Team> findAllByAgeGroup(Age age){
        return teamsRepository.findAllByAgeGroup(age.getAge_id());
    }

    public List<Team> findAllSenior(){
        return teamsRepository.findAllSenior();
    }

    public List<Team> findAllJunior(){
        return teamsRepository.findAllJunior();
    }


    public List<TeamStanding> findTeamStandings(int i){
//        ('Grade 8'),  --1
//        ('Grade 9'),  --2
//        ('Grade 10'), --3
//        ('Grade 11'), --4
//        ('Grade 12'), --5
//        ('Jr Prep'),       --6
//        ('Sr Prep'),       --7
//        ('Jr Rep'),        --8
//        ('Sr Rep');        --9



        List<TeamStanding> result = new ArrayList<>();
        List<Tuple> tuples;

             tuples =   switch (i) {
            case 1 -> teamsRepository.findTeamStandingsByAgeGroup("Grade 8");
            case 8 -> teamsRepository.findTeamStandingsByAgeGroup("Jr Rep");
            case 9 -> teamsRepository.findTeamStandingsByAgeGroup("Sr Rep");
            case 6 -> teamsRepository.findTeamStandingsByAgeGroup("Jr Prep");
            case 7 -> teamsRepository.findTeamStandingsByAgeGroup("Sr Prep");
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };

             if(tuples.isEmpty()){
                 return result;
             }
             for (Tuple tuple:tuples){
                 String teamName = tuple.get(0, String.class);

                 Long gamesPlayed = Long.valueOf(0);
                 if(tuple.get(1) != null){
                     gamesPlayed = tuple.get(1, Long.class);
                 }

                 Long wins = Long.valueOf(0);
                 if(tuple.get(2) != null){
                     wins = tuple.get(2, Long.class);
                 }

                 Long losses = Long.valueOf(0);
                 if(tuple.get(3) != null){
                     losses = tuple.get(3, Long.class);
                 }

                 Long pf = Long.valueOf(0);
                 if(tuple.get(4) != null){
                     pf = tuple.get(4, Long.class);
                 }

                 Long pa = Long.valueOf(0);
                 if(tuple.get(5) != null){
                     pa = tuple.get(5, Long.class);
                 }
                 int id = tuple.get(6, Integer.class);
                 TeamStanding teamStanding = new TeamStanding(
                teamName, // team_name
                id,
                gamesPlayed, // games_played
                wins,
                losses, // losses
                pf, // points_for
                pa);  // points_against

                result.add(teamStanding);
             }


        return result;
    }

    public void save(Team team) {
        teamsRepository.save(team);
    }
}
