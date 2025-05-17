package com.example.jobportal.model.entity;

import com.example.jobportal.model.enums.JobStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Jobs")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Users recruiter;

    private String title;
    private String description;
    private String requirements;
    private String salary;
    private String location;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private LocalDateTime createdAt;
}
