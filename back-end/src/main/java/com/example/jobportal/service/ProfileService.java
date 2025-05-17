
package com.example.jobportal.service;

import com.example.jobportal.dto.ProfileDTO;

public interface ProfileService {
    ProfileDTO getProfileByUserId(int userId);
    void updateProfile(int userId, ProfileDTO profileDTO);
    void deleteProfile(int userId);
    void createProfile(int userId, ProfileDTO profileDTO);

}
