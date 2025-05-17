package com.example.jobportal.model.entity;


import com.example.jobportal.model.enums.ReportTargetType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Complants")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Complaints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaintId;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private Users reporter;

    @Enumerated(EnumType.STRING)
    private ReportTargetType targetType;

    private Integer targetId;
    private String content;
    private LocalDateTime submittedAt;
}
