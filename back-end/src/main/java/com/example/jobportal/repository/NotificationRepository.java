package com.example.jobportal.repository;

import com.example.jobportal.model.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications, Integer> {

}
