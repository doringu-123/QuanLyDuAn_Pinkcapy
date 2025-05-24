package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ModerationLogs")
public class ModerationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "userId")
    private User admin;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "jobId")
    private Job job;

    @Enumerated(EnumType.STRING)
    private Action action;

    private String note;

    private LocalDateTime moderatedAt;

    public enum Action {
        Approved, Rejected, Flagged
    }
}