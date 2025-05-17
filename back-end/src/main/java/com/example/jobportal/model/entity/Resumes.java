package com.example.jobportal.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Resumes")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Resumes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resumeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private String title;
    private String content;
    private LocalDateTime createdAt;
}
