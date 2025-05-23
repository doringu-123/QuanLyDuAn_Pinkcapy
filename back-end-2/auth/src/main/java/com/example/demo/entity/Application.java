package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name = "resume_id", referencedColumnName = "resumeId")
    private Resume resume;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "jobId")
    private Job job;

    private LocalDateTime appliedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        Submitted, UnderReview, Rejected, Accepted
    }
}