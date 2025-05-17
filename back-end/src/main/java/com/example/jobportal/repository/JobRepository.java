package com.example.jobportal.repository;

import com.example.jobportal.model.entity.Jobs;
import com.example.jobportal.model.entity.Users;
import com.example.jobportal.model.enums.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Jobs, Integer> {
    List<Jobs> findByStatus(JobStatus status);
    List<Jobs> findByRecruiter(Users recruiter);
}
