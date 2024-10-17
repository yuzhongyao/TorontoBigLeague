package com.example.demo.services;


import com.example.demo.entities.Location;
import com.example.demo.repositories.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {

    private final LocationsRepository locationsRepository;

    @Autowired
    public LocationsService(LocationsRepository locationsRepository){
        this.locationsRepository = locationsRepository;
    }

    public List<Location> findAll() {
        return locationsRepository.findAll();
    }

    public void save(Location location) {
        locationsRepository.save(location);
    }
}
