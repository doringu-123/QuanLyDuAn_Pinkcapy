package com.example.jobportal.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "EmployerReviews")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployerReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Users recruiter;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Users candidate;

    private Integer rating;
    private String comment;
    private LocalDateTime reviewedAt;

    // Getters and setters
}
