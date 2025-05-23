package com.example.demo.service;

import com.example.demo.dto.ApplicationRequest;
import com.example.demo.dto.ApplicationResponse;
import com.example.demo.entity.Application;
import com.example.demo.entity.Job;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    public ApplicationResponse applyForJob(ApplicationRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getRole().equals(User.Role.Candidate)) {
            throw new RuntimeException("Only candidates can apply for jobs");
        }

        Resume resume = resumeRepository.findById(request.getResumeId())
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        if (!resume.getUser().getUserId().equals(user.getUserId())) {
            throw new RuntimeException("You can only apply with your own resume");
        }

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getStatus().equals(Job.Status.Visible)) {
            throw new RuntimeException("Cannot apply for this job");
        }

        Application application = new Application();
        application.setResume(resume);
        application.setJob(job);
        application.setStatus(Application.Status.Submitted);
        application = applicationRepository.save(application);

        return mapToResponse(application);
    }

    public List<ApplicationResponse> getApplications() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return applicationRepository.findByResumeUserUserId(user.getUserId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ApplicationResponse mapToResponse(Application application) {
        ApplicationResponse response = new ApplicationResponse();
        response.setApplicationId(application.getApplicationId());
        response.setResumeId(application.getResume().getResumeId());
        response.setJobId(application.getJob().getJobId());
        response.setAppliedAt(application.getAppliedAt());
        response.setStatus(application.getStatus().name());
        return response;
    }
}