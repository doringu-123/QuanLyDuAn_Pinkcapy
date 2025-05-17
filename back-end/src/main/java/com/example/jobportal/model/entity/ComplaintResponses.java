package com.example.jobportal.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ComplaintReponses")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComplaintResponses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer responseId;

    @ManyToOne
    @JoinColumn(name = "complaint_id")
    private Complaints complaint;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Users admin;

    private String content;
    private LocalDateTime respondedAt;
}
