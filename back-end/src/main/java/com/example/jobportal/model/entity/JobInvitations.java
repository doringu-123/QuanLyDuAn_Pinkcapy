package com.example.jobportal.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "JobInvitations")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobInvitations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invitationId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs job;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Users candidate;

    private String subject;
    private String message;
    private LocalDateTime sentAt;
}
