package com.example.javaweappproject.repository;

import com.example.javaweappproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    // SQLite Db Connection and Processing
}
