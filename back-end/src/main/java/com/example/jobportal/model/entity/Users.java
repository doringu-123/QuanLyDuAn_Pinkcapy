package com.example.jobportal.model.entity;

import com.example.jobportal.model.enums.Role;
import com.example.jobportal.model.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String fullName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    // Getters and setters
}