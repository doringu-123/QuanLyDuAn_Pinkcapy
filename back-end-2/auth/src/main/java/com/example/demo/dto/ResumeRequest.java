package com.example.demo.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ResumeRequest {
    private String title;
    private MultipartFile file; // File PDF
}