package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ResumeResponse {
    private Integer resumeId;
    private Integer userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}