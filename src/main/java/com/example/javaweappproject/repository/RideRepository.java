package com.example.javaweappproject.repository;

import com.example.javaweappproject.model.Ride;
import org.springframework.data.repository.CrudRepository;

public interface RideRepository extends CrudRepository<Ride, Long> {
    // SQLite Db Connection and Processing
}
