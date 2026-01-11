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
        if (age.getAge_group().equals("All")){
            return teamsRepository.findAll();
        }
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
        List<Object[]> tuples;

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
             for (Object[] object:tuples){
                 String teamName = object[0].toString();

                 Long gamesPlayed = Long.valueOf(0);
                 if(object[1] != null){
                     gamesPlayed = (Long) object[1];
                 }

                 Long wins = Long.valueOf(0);
                 if(object[2] != null){
                     wins = (Long) object[2];
                 }

                 Long losses = Long.valueOf(0);
                 if(object[3] != null){
                     losses = (Long) object[3];
                 }

                 Long pf = Long.valueOf(0);
                 if(object[4] != null){
                     pf = (Long) object[4];
                 }

                 Long pa = Long.valueOf(0);
                 if(object[5] != null){
                     pa = (Long) object[5];
                 }
                 int id = (Integer) object[6];
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
