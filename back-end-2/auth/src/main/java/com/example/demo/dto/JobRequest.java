package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class JobRequest {
    private String title;
    private String description;
    private String requirements;
    private String salary;
    private String location;
    private LocalDate deadline;
}