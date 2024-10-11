package com.example.demo.services;

import com.example.demo.entities.Age;
import com.example.demo.entities.Team;
import com.example.demo.repositories.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



}
