package com.example.demo.dto;

import lombok.Data;

@Data
public class UserStatsResponse {
    private Long candidatesActive;
    private Long candidatesInactive;
    private Long recruitersActive;
    private Long recruitersInactive;
    private Long adminsActive;
    private Long adminsInactive;
}