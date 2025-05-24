package com.example.demo.service;

import com.example.demo.dto.ApplicationStatsResponse;
import com.example.demo.dto.JobStatsResponse;
import com.example.demo.dto.UserStatsResponse;
import com.example.demo.entity.Application;
import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public UserStatsResponse getUserStats() {
        validateAdminRole();

        UserStatsResponse response = new UserStatsResponse();
        response.setCandidatesActive(userRepository.countByRoleAndStatus(User.Role.Candidate, User.Status.Active));
        response.setCandidatesInactive(userRepository.countByRoleAndStatus(User.Role.Candidate, User.Status.Inactive));
        response.setRecruitersActive(userRepository.countByRoleAndStatus(User.Role.Recruiter, User.Status.Active));
        response.setRecruitersInactive(userRepository.countByRoleAndStatus(User.Role.Recruiter, User.Status.Inactive));
        response.setAdminsActive(userRepository.countByRoleAndStatus(User.Role.Admin, User.Status.Active));
        response.setAdminsInactive(userRepository.countByRoleAndStatus(User.Role.Admin, User.Status.Inactive));

        return response;
    }

    public JobStatsResponse getJobStats() {
        validateAdminRole();

        JobStatsResponse response = new JobStatsResponse();
        response.setVisible((long) jobRepository.findByStatus(Job.Status.Visible).size());
        response.setBanned((long) jobRepository.findByStatus(Job.Status.Banned).size());
        response.setDeleted((long) jobRepository.findByStatus(Job.Status.Deleted).size());

        return response;
    }

    public ApplicationStatsResponse getApplicationStats() {
        validateAdminRole();

        ApplicationStatsResponse response = new ApplicationStatsResponse();
        response.setSubmitted((long) applicationRepository.findAll().stream()
                .filter(app -> app.getStatus() == Application.Status.Submitted).count());
        response.setUnderReview((long) applicationRepository.findAll().stream()
                .filter(app -> app.getStatus() == Application.Status.UnderReview).count());
        response.setRejected((long) applicationRepository.findAll().stream()
                .filter(app -> app.getStatus() == Application.Status.Rejected).count());
        response.setAccepted((long) applicationRepository.findAll().stream()
                .filter(app -> app.getStatus() == Application.Status.Accepted).count());

        return response;
    }

    private void validateAdminRole() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User admin = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (!admin.getRole().equals(User.Role.Admin)) {
            throw new RuntimeException("Only admins can access statistics");
        }
    }
}