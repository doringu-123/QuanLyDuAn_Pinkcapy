package com.example.jobportal.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfileDTO {
    private LocalDate birthDate;
    private String gender;
    private String phoneNumber;
    private String address;
    private String summary;
}
