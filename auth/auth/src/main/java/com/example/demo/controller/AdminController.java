package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @PostMapping("/ban/{userId}")
    public ResponseEntity<?> banUser(@PathVariable Integer userId) {
        adminService.banUser(userId);
        return ResponseEntity.ok("User banned successfully");
    }

    @PostMapping("/unban/{userId}")
    public ResponseEntity<?> unbanUser(@PathVariable Integer userId) {
        adminService.unbanUser(userId);
        return ResponseEntity.ok("User unbanned successfully");
    }
}