package com.example.demo.controller;

import com.example.demo.dto.ApplicationRequest;
import com.example.demo.dto.ApplicationResponse;
import com.example.demo.dto.ResumeRequest;
import com.example.demo.dto.ResumeResponse;
import com.example.demo.service.ApplicationService;
import com.example.demo.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private ApplicationService applicationService;

    // Quản lý CV
    @PostMapping("/resumes")
    public ResponseEntity<ResumeResponse> createResume(@ModelAttribute ResumeRequest request) throws IOException {
        return ResponseEntity.ok(resumeService.createResume(request));
    }

    @DeleteMapping("/resumes/{resumeId}")
    public ResponseEntity<?> deleteResume(@PathVariable Integer resumeId) {
        resumeService.deleteResume(resumeId);
        return ResponseEntity.ok("Resume deleted successfully");
    }

    @GetMapping("/resumes")
    public ResponseEntity<List<ResumeResponse>> getResumes() {
        return ResponseEntity.ok(resumeService.getResumes());
    }

    @GetMapping("/resumes/{resumeId}")
    public ResponseEntity<ResumeResponse> getResume(@PathVariable Integer resumeId) {
        return ResponseEntity.ok(resumeService.getResume(resumeId));
    }

    // Ứng tuyển công việc
    @PostMapping("/applications")
    public ResponseEntity<ApplicationResponse> applyForJob(@RequestBody ApplicationRequest request) {
        return ResponseEntity.ok(applicationService.applyForJob(request));
    }

    @GetMapping("/applications")
    public ResponseEntity<List<ApplicationResponse>> getApplications() {
        return ResponseEntity.ok(applicationService.getApplications());
    }
}