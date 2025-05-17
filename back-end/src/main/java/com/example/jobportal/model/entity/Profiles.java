package com.example.jobportal.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Profiles")
public class Profiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;

    private String summary;
}
