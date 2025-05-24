package com.example.demo.dto;

import lombok.Data;

@Data
public class ModerateJobRequest {
    private String action; // Approved, Rejected, Flagged
    private String note; // Optional note for the moderation action
}