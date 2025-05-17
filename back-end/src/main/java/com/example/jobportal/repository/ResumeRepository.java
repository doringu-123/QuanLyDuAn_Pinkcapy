package com.example.jobportal.repository;

import com.example.jobportal.model.entity.Resumes;
import com.example.jobportal.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resumes, Integer> {
    List<Resumes> findByUser(Users user);

}
