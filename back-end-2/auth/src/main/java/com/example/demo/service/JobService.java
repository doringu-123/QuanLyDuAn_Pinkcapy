package com.example.demo.service;

import com.example.demo.dto.JobRequest;
import com.example.demo.dto.JobResponse;
import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    public JobResponse createJob(JobRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!recruiter.getRole().equals(User.Role.Recruiter)) {
            throw new RuntimeException("Only recruiters can create jobs");
        }

        if (request.getDeadline().isBefore(LocalDate.now())) {
            throw new RuntimeException("Deadline must be in the future");
        }

        Job job = new Job();
        job.setRecruiter(recruiter);
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setRequirements(request.getRequirements());
        job.setSalary(request.getSalary());
        job.setLocation(request.getLocation());
        job.setDeadline(request.getDeadline());
        job.setStatus(Job.Status.Visible);

        job = jobRepository.save(job);
        return mapToResponse(job);
    }

    public JobResponse updateJob(Integer jobId, JobRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getRecruiter().getUserId().equals(recruiter.getUserId())) {
            throw new RuntimeException("You can only update your own jobs");
        }

        if (request.getDeadline().isBefore(LocalDate.now())) {
            throw new RuntimeException("Deadline must be in the future");
        }

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setRequirements(request.getRequirements());
        job.setSalary(request.getSalary());
        job.setLocation(request.getLocation());
        job.setDeadline(request.getDeadline());

        job = jobRepository.save(job);
        return mapToResponse(job);
    }

    public void deleteJob(Integer jobId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getRecruiter().getUserId().equals(recruiter.getUserId())) {
            throw new RuntimeException("You can only delete your own jobs");
        }

        job.setStatus(Job.Status.Deleted);
        jobRepository.save(job);
    }

    public List<JobResponse> getJobs() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return jobRepository.findByRecruiterUserId(recruiter.getUserId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public JobResponse getJob(Integer jobId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User recruiter = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (!job.getRecruiter().getUserId().equals(recruiter.getUserId())) {
            throw new RuntimeException("You can only view your own jobs");
        }

        return mapToResponse(job);
    }

    private JobResponse mapToResponse(Job job) {
        JobResponse response = new JobResponse();
        response.setJobId(job.getJobId());
        response.setRecruiterId(job.getRecruiter().getUserId());
        response.setTitle(job.getTitle());
        response.setDescription(job.getDescription());
        response.setRequirements(job.getRequirements());
        response.setSalary(job.getSalary());
        response.setLocation(job.getLocation());
        response.setDeadline(job.getDeadline());
        response.setStatus(job.getStatus().name());
        response.setCreatedAt(job.getCreatedAt());
        return response;
    }
}