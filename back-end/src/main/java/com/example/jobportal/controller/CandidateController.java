package com.example.jobportal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @GetMapping("/profile")
    public ResponseEntity<String> viewProfile() {
        return ResponseEntity.ok("CANDIDATE: Xem hồ sơ cá nhân");
    }
}
