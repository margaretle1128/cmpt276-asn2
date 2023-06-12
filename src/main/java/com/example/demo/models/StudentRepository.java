package com.example.demo.models;

import java.util.Optional;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findById(Integer uid);
    
}
