package com.example.demo.service;

import com.example.demo.dto.ModerateJobRequest;
import com.example.demo.dto.ModerationLogResponse;
import com.example.demo.entity.Job;
import com.example.demo.entity.ModerationLog;
import com.example.demo.entity.User;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.ModerationLogRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ModerationService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ModerationLogRepository moderationLogRepository;

    @Autowired
    private UserRepository userRepository;

    public ModerationLogResponse moderateJob(Integer jobId, ModerateJobRequest request) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User admin = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (!admin.getRole().equals(User.Role.Admin)) {
            throw new RuntimeException("Only admins can moderate jobs");
        }

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        ModerationLog.Action action;
        try {
            action = ModerationLog.Action.valueOf(request.getAction());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid action: " + request.getAction());
        }

        // Update job status based on moderation action
        switch (action) {
            case Approved:
                job.setStatus(Job.Status.Visible);
                break;
            case Rejected:
                job.setStatus(Job.Status.Banned);
                break;
            case Flagged:
                job.setStatus(Job.Status.Deleted);
                break;
        }

        jobRepository.save(job);

        // Create moderation log
        ModerationLog log = new ModerationLog();
        log.setAdmin(admin);
        log.setJob(job);
        log.setAction(action);
        log.setNote(request.getNote());
        log = moderationLogRepository.save(log);

        return mapToResponse(log);
    }

    private ModerationLogResponse mapToResponse(ModerationLog log) {
        ModerationLogResponse response = new ModerationLogResponse();
        response.setLogId(log.getLogId());
        response.setAdminId(log.getAdmin().getUserId());
        response.setJobId(log.getJob().getJobId());
        response.setAction(log.getAction().name());
        response.setNote(log.getNote());
        response.setModeratedAt(log.getModeratedAt());
        return response;
    }
}