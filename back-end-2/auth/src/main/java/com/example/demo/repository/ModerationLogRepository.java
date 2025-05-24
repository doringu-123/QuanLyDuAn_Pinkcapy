package com.example.demo.repository;

import com.example.demo.entity.ModerationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModerationLogRepository extends JpaRepository<ModerationLog, Integer> {
}