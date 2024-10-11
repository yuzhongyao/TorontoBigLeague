package com.example.demo.services;


import com.example.demo.entities.Season;
import com.example.demo.repositories.SeasonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonsService {

    private final SeasonsRepository seasonsRepository;

    @Autowired
    public SeasonsService(SeasonsRepository seasonsRepository){
        this.seasonsRepository = seasonsRepository;
    }

    public Season getCurrent() {
        return seasonsRepository.getCurrent();
    }
}
