package com.example.jobportal.repository;

import com.example.jobportal.model.entity.Jobs;
import com.example.jobportal.model.entity.ModerationsLogs;
import com.example.jobportal.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeratioinLogRepository extends JpaRepository<ModerationsLogs, Integer> {
    List<ModerationsLogs> findByAdmin(Users admin);
    List<ModerationsLogs> findByJob(Jobs job);
}
