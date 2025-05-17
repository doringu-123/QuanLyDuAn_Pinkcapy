
package com.example.jobportal.controller;

import com.example.jobportal.dto.ProfileDTO;
import com.example.jobportal.security.CustomUserDetails;
import com.example.jobportal.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profilesService;


    @GetMapping("/me")
    public ResponseEntity<ProfileDTO> getMyProfile(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(profilesService.getProfileByUserId(userDetails.getId()));
    }

    @PutMapping
    public ResponseEntity<String> updateProfile(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                @RequestBody ProfileDTO dto) {
        profilesService.updateProfile(userDetails.getId(), dto);
        return ResponseEntity.ok("Profile updated successfully.");
    }

    @PostMapping
    public ResponseEntity<String> createProfile(@AuthenticationPrincipal CustomUserDetails userDetails,
                                                @RequestBody ProfileDTO dto) {
        profilesService.createProfile(userDetails.getId(), dto);
        return ResponseEntity.ok("Profile created successfully.");
    }

}
