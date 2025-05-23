package com.example.demo.repository;

import com.example.demo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    List<Job> findByStatus(Job.Status status);
}