package com.example.jobportal.repository;

import com.example.jobportal.model.entity.Reports;
import com.example.jobportal.model.entity.Users;
import com.example.jobportal.model.enums.ReportTargetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Reports, Integer> {
    List<Reports> findByReporter(Users reporter);
    List<Reports> findByTargetTypeAndTargetId(ReportTargetType targetType, Integer targetId);
}
