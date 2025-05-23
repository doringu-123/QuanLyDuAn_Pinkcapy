package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", referencedColumnName = "userId")
    private User recruiter;

    private String title;
    private String description;
    private String requirements;
    private String salary;
    private String location;
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    public enum Status {
        Visible, Banned, Deleted
    }
}