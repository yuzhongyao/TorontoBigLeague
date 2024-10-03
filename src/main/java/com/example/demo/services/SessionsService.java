package com.example.demo.services;

import com.example.demo.repositories.SessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionsService {


    private final SessionsRepository sessionsRepository;


    public SessionsService(SessionsRepository sessionsRepository) {
        this.sessionsRepository = sessionsRepository;
    }






}
