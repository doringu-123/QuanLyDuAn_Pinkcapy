package com.example.jobportal.repository;

import com.example.jobportal.model.entity.EmployerReviews;
import com.example.jobportal.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerReviewRepository extends JpaRepository<EmployerReviews, Integer> {
    List<EmployerReviews> findByRecruiter(Users recruiter);
    List<EmployerReviews> findByCandidate(Users candidate);
}
