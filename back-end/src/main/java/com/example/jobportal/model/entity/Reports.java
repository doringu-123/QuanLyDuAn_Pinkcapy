package com.example.jobportal.model.entity;

import com.example.jobportal.model.enums.ReportTargetType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reports")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private Users reporter;

    @Enumerated(EnumType.STRING)
    private ReportTargetType targetType;

    private Integer targetId;
    private String reason;
    private LocalDateTime reportedAt;
}
