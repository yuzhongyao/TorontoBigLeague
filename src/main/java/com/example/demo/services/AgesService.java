package com.example.demo.services;


import com.example.demo.repositories.AgesRepository;
import com.example.demo.repositories.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgesService {
    private final AgesRepository agesRepository;

    @Autowired
    public AgesService(AgesRepository agesRepository){
        this.agesRepository = agesRepository;
    }
}