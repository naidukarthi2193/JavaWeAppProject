package com.example.javaweappproject.service;

import com.example.javaweappproject.model.Ride;
import com.example.javaweappproject.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShuttleService {
    private final RideRepository rideRepository;

    @Autowired
    public ShuttleService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public void addRide(String suid, String address) {
        Ride ride = new Ride();
        ride.setSuid(suid);
        ride.setAddress(address);
        rideRepository.save(ride);
    }

    public List<Ride> getAllRides() {
        return (List<Ride>) rideRepository.findAll();
    }

    public void clearRides() {
        rideRepository.deleteAll();
    }
    public void deleteRide(Ride ride) {
        rideRepository.delete(ride);
    }
}
