package com.example.demo.controller;

import com.example.demo.dto.ModerateJobRequest;
import com.example.demo.dto.ModerationLogResponse;
import com.example.demo.dto.UserStatsResponse;
import com.example.demo.dto.JobStatsResponse;
import com.example.demo.dto.ApplicationStatsResponse;
import com.example.demo.service.ModerationService;
import com.example.demo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private ModerationService moderationService;

    @Autowired
    private StatisticsService statisticsService;

    // Duyệt và ẩn bài đăng tuyển dụng
    @PutMapping("/jobs/{jobId}/moderate")
    public ResponseEntity<ModerationLogResponse> moderateJob(
            @PathVariable Integer jobId,
            @RequestBody ModerateJobRequest request) {
        return ResponseEntity.ok(moderationService.moderateJob(jobId, request));
    }

    // Thống kê
    @GetMapping("/stats/users")
    public ResponseEntity<UserStatsResponse> getUserStats() {
        return ResponseEntity.ok(statisticsService.getUserStats());
    }

    @GetMapping("/stats/jobs")
    public ResponseEntity<JobStatsResponse> getJobStats() {
        return ResponseEntity.ok(statisticsService.getJobStats());
    }

    @GetMapping("/stats/applications")
    public ResponseEntity<ApplicationStatsResponse> getApplicationStats() {
        return ResponseEntity.ok(statisticsService.getApplicationStats());
    }
}