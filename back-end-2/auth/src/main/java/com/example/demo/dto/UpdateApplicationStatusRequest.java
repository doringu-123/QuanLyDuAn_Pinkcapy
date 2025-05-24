package com.example.demo.dto;

import lombok.Data;

@Data
public class UpdateApplicationStatusRequest {
    private String status; // Submitted, UnderReview, Rejected, Accepted
}