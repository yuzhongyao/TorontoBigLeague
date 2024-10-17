package com.example.demo.repositories;

import com.example.demo.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepository extends JpaRepository<Location, Integer> {
}
