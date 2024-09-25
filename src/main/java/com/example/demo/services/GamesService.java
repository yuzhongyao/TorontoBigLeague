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

}
