package com.example.jobportal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {

    @GetMapping("/jobs")
    public ResponseEntity<String> manageJobs() {
        return ResponseEntity.ok("RECRUITER: Quản lý tin tuyển dụng");
    }
}
