package com.example.demo.dto;

import lombok.Data;

@Data
public class ApplicationStatsResponse {
    private Long submitted;
    private Long underReview;
    private Long rejected;
    private Long accepted;
}