package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JobResponse {
    private Integer jobId;
    private Integer recruiterId;
    private String title;
    private String description;
    private String requirements;
    private String salary;
    private String location;
    private LocalDate deadline;
    private String status;
    private LocalDateTime createdAt;
}