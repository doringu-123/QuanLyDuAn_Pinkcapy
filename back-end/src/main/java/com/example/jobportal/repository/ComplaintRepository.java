package com.example.jobportal.repository;

import com.example.jobportal.model.entity.Complaints;
import com.example.jobportal.model.entity.Users;
import com.example.jobportal.model.enums.ReportTargetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaints, Integer> {
    List<Complaints> findByReporter(Users reporter);
    List<Complaints> findByTargetTypeAndTargetId(ReportTargetType targetType, Integer targetId);
}

