package com.example.demo.services;

import com.example.demo.entities.Game;
import com.example.demo.repositories.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {
    private final GamesRepository gamesRepository;

    @Autowired
    public GamesService(GamesRepository gamesRepository){
        this.gamesRepository = gamesRepository;
    }

    public List<Game>getCurrentSeasonGames(){
        return gamesRepository.getCurrentSeasonGames();
    }

//            ('Grade 8'),  --1
//            ('Grade 9'),  --2
//            ('Grade 10'), --3
//            ('Grade 11'), --4
//            ('Grade 12'), --5
//            ('Jr'),       --6
//            ('Sr');       --7
    public List<Game> getMiddleSchoolGames() {
        return gamesRepository.getUpcomingGamesByAge(1);
    }

    public List<Game> getPastMiddleSchoolGames(){return gamesRepository.getPastGamesByAge(1);}


    public List<Game> getJrGames() {
        return gamesRepository.getUpcomingGamesByAge(6);
    }
    public List<Game> getPastJrGames(){return gamesRepository.getPastGamesByAge(6);}


    public List<Game> getSrGames(){
        return gamesRepository.getUpcomingGamesByAge(7);
    }

    public List<Game> getPastSrGames(){return gamesRepository.getPastGamesByAge(6);}


}
