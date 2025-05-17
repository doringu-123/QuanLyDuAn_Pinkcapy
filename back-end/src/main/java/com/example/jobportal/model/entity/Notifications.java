package com.example.jobportal.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notifications")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private String message;
    private Boolean isRead = false;
    private LocalDateTime sentAt;

    // Getters and setters
}
