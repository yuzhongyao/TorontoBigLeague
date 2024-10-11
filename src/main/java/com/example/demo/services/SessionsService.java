package com.example.demo.services;

import com.example.demo.entities.Session;
import com.example.demo.repositories.SessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SessionsService {


    private final SessionsRepository sessionsRepository;


    public SessionsService(SessionsRepository sessionsRepository) {
        this.sessionsRepository = sessionsRepository;
    }


    public List<Session> getSessions() {
        return sessionsRepository.findAll();
    }
}
