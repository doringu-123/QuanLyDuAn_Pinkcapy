package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApplicationResponse {
    private Integer applicationId;
    private Integer resumeId;
    private Integer jobId;
    private LocalDateTime appliedAt;
    private String status;
}