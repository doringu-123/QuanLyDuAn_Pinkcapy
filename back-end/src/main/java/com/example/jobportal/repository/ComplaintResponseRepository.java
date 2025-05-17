package com.example.jobportal.repository;

import com.example.jobportal.model.entity.ComplaintResponses;
import com.example.jobportal.model.entity.Complaints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintResponseRepository extends JpaRepository<ComplaintResponses, Integer> {
    List<ComplaintResponses> findByComplaint(Complaints complaint);

}
