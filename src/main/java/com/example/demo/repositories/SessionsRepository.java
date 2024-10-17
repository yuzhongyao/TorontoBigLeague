package com.example.demo.repositories;

import com.example.demo.entities.Game;
import com.example.demo.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionsRepository extends JpaRepository<Session, Integer> {


    @Query(value = "select * from sessions where age_id = :ageId "
            , nativeQuery = true)
    List<Session> getSessionsByAge(@Param("ageId") int ageId);

}
