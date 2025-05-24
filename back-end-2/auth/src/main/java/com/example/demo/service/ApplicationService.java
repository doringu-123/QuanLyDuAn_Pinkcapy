package com.example.demo.service;

import com.example.demo.dto.ApplicationRequest;
import com.example.demo.dto.ApplicationResponse;
import com.example.demo.dto.UpdateApplicationStatusRequest;
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

    // Chức năng ứng tuyển (đã có từ trước)
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

    // Chức năng xem danh sách ứng tuyển của Candidate (đã có từ trước)
    public List<ApplicationResponse> getApplications() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return applicationRepository.findByResumeUserUserId(user.getUserId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Chức năng mới: Xem danh sách ứng tuyển cho công việc của Recruiter
    public List<ApplicationResponse> getApplicationsForRecruiter() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!recruiter.getRole().equals(User.Role.Recruiter)) {
            throw new RuntimeException("Only recruiters can view applications");
        }

        return applicationRepository.findByJobRecruiterUserId(recruiter.getUserId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Chức năng mới: Cập nhật trạng thái đơn ứng tuyển
    public ApplicationResponse updateApplicationStatus(Integer applicationId, UpdateApplicationStatusRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        if (!application.getJob().getRecruiter().getUserId().equals(recruiter.getUserId())) {
            throw new RuntimeException("You can only update applications for your own jobs");
        }

        try {
            Application.Status status = Application.Status.valueOf(request.getStatus());
            application.setStatus(status);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + request.getStatus());
        }

        application = applicationRepository.save(application);
        return mapToResponse(application);
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