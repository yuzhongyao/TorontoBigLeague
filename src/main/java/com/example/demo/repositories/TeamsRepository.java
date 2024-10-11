package com.example.demo.repositories;

import com.example.demo.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamsRepository extends JpaRepository<Team, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM teams WHERE " +
            "teams.age_id = :ageId ")
    List<Team> findAllByAgeGroup(@Param("ageId") int ageId);
}
