package com.example.demo.controller;

import com.example.demo.dto.ApplicationResponse;
import com.example.demo.dto.JobRequest;
import com.example.demo.dto.JobResponse;
import com.example.demo.dto.UpdateApplicationStatusRequest;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {

    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicationService applicationService;

    // Quản lý bài đăng công việc
    @PostMapping("/jobs")
    public ResponseEntity<JobResponse> createJob(@RequestBody JobRequest request) {
        return ResponseEntity.ok(jobService.createJob(request));
    }

    @PutMapping("/jobs/{jobId}")
    public ResponseEntity<JobResponse> updateJob(@PathVariable Integer jobId, @RequestBody JobRequest request) {
        return ResponseEntity.ok(jobService.updateJob(jobId, request));
    }

    @DeleteMapping("/jobs/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable Integer jobId) {
        jobService.deleteJob(jobId);
        return ResponseEntity.ok("Job deleted successfully");
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobResponse>> getJobs() {
        return ResponseEntity.ok(jobService.getJobs());
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<JobResponse> getJob(@PathVariable Integer jobId) {
        return ResponseEntity.ok(jobService.getJob(jobId));
    }

    // Quản lý đơn ứng tuyển
    @GetMapping("/applications")
    public ResponseEntity<List<ApplicationResponse>> getApplications() {
        return ResponseEntity.ok(applicationService.getApplicationsForRecruiter());
    }

    @PutMapping("/applications/{applicationId}/status")
    public ResponseEntity<ApplicationResponse> updateApplicationStatus(
            @PathVariable Integer applicationId,
            @RequestBody UpdateApplicationStatusRequest request) {
        return ResponseEntity.ok(applicationService.updateApplicationStatus(applicationId, request));
    }
}