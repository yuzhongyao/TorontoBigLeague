package com.example.demo.repositories;

import com.example.demo.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionsRepository extends JpaRepository<Session, Integer> {
}
