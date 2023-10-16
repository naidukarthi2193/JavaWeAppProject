package com.example.javaweappproject.controller;

import com.example.javaweappproject.model.Ride;
import com.example.javaweappproject.model.Student;
import com.example.javaweappproject.repository.StudentRepository;
import com.example.javaweappproject.service.ShuttleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShuttleController {
    private final StudentRepository studentRepository;
    private final ShuttleService shuttleService;

    @Autowired
    public ShuttleController(StudentRepository studentRepository, ShuttleService shuttleService) {
        this.studentRepository = studentRepository;
        this.shuttleService = shuttleService;
    }

    @GetMapping("/students/{suid}")
    public ResponseEntity<Student> getStudent(@PathVariable String suid) {
        Student student = studentRepository.findById(suid).orElse(null);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/rides")
    public ResponseEntity<String> addRide(@RequestBody Ride ride) {
        shuttleService.addRide(ride.getSuid(), ride.getAddress());
        return ResponseEntity.ok("Ride added to the list");
    }

    @GetMapping("/rides")
    public ResponseEntity<List<Ride>> getAllRides() {
        List<Ride> rides = shuttleService.getAllRides();
        return ResponseEntity.ok(rides);
    }

    @DeleteMapping("/rides")
    public ResponseEntity<String> clearRides() {
        shuttleService.clearRides();
        return ResponseEntity.ok("Ride list cleared");
    }

    @DeleteMapping("/rides/current")
    public ResponseEntity<String> deleteCurrentRide() {
        List<Ride> rides = shuttleService.getAllRides();
        if (!rides.isEmpty()) {
            Ride currentRide = rides.get(0);
            shuttleService.deleteRide(currentRide);
            return ResponseEntity.ok("Current ride deleted");
        } else {
            return ResponseEntity.ok("No rides to delete");
        }
    }
}
