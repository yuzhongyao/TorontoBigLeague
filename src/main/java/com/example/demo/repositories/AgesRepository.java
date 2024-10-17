package com.example.demo.repositories;


import com.example.demo.entities.Age;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgesRepository extends JpaRepository<Age, Integer> {

}
