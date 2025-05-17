package com.example.jobportal.repository;

import com.example.jobportal.model.entity.JobInvitations;
import com.example.jobportal.model.entity.Jobs;
import com.example.jobportal.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobInvitationRepository extends JpaRepository<JobInvitations, Integer> {
    List<JobInvitations> findByCandidate(Users candidate);
    List<JobInvitations> findByJob(Jobs job);
}
