package com.example.demo.repositories;

import com.example.demo.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonsRepository extends JpaRepository<Season, Integer> {

    @Query(value = "SELECT * FROM seasons ORDER BY season_id DESC LIMIT 1", nativeQuery = true)
    Season getCurrent();

}
