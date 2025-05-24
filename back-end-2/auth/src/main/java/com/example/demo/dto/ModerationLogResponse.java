package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ModerationLogResponse {
    private Integer logId;
    private Integer adminId;
    private Integer jobId;
    private String action;
    private String note;
    private LocalDateTime moderatedAt;
}