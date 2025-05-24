package com.example.demo.repository;

import com.example.demo.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByResumeUserUserId(Integer userId);
    List<Application> findByJobRecruiterUserId(Integer recruiterId);}