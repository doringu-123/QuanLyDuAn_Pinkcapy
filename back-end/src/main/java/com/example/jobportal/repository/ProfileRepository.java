package com.example.jobportal.repository;


import com.example.jobportal.model.entity.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profiles, Integer> {
    Optional<Profiles> findByUserId(Integer userId);
    void deleteByUserId(Integer userId);
}
