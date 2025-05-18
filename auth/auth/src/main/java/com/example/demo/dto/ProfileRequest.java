package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ProfileRequest {
    private LocalDate birthDate;
    private String gender;
    private String phoneNumber;
    private String address;
    private String summary;
}