package com.example.jobportal.model.entity;

import com.example.jobportal.model.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Applications")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resume;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;

    private LocalDateTime appliedAt;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
}
