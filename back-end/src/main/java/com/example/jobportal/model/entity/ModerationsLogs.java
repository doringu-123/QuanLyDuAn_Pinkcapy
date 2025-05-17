package com.example.jobportal.model.entity;



import com.example.jobportal.model.enums.ModerationAction;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ModerationsLogs")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModerationsLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Users admin;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;

    @Enumerated(EnumType.STRING)
    private ModerationAction action;

    private String note;
    private LocalDateTime moderatedAt;
}
