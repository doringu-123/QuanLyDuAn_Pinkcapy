package com.example.jobportal.repository;

import com.example.jobportal.model.entity.Applications;
import com.example.jobportal.model.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Applications, Integer> {
    List<Applications> findByResume_User_UserId(Integer userId);
    List<Applications> findByJob(Jobs job);
}
