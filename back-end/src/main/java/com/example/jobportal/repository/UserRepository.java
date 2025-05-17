package com.example.jobportal.repository;

import com.example.jobportal.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    static Optional<Users> findByEmail(String email);

}
