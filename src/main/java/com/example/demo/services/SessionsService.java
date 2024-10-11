package com.example.demo.services;

import com.example.demo.entities.Age;
import com.example.demo.entities.Session;
import com.example.demo.repositories.SessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionsService {


    private final SessionsRepository sessionsRepository;


    @Autowired
    public SessionsService(SessionsRepository sessionsRepository) {
        this.sessionsRepository = sessionsRepository;
    }


    public List<Session> getSessions() {
        return sessionsRepository.findAll();
    }

    public List<Session> getSessionsByAge(Age age) {
        return sessionsRepository.getSessionsByAge(age.getAge_id());
    }
}
