package com.example.demo.dto;

import lombok.Data;

@Data
public class JobStatsResponse {
    private Long visible;
    private Long banned;
    private Long deleted;
}