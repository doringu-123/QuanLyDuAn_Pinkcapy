package com.example.jobportal.serviceImpl;

import com.example.jobportal.dto.ProfileDTO;
import com.example.jobportal.model.entity.Profiles;
import com.example.jobportal.repository.ProfileRepository;
import com.example.jobportal.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profilesRepository;

    @Override
    public ProfileDTO getProfileByUserId(int userId) {
        Profiles profile = profilesRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("Profile not found"));
        return mapToDTO(profile);
    }

    @Override
    public void updateProfile(int userId, ProfileDTO dto) {
        Profiles profile = profilesRepository.findByUserId(userId).orElse(new Profiles());
        profile.setUserId(userId);
        profile.setBirthDate(dto.getBirthDate());
        profile.setGender(dto.getGender());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setAddress(dto.getAddress());
        profile.setSummary(dto.getSummary());
        profilesRepository.save(profile);
    }

    @Override
    public void deleteProfile(int userId) {
        profilesRepository.deleteByUserId(userId);
    }

    @Override
    public void createProfile(int userId, ProfileDTO dto) {
        if (profilesRepository.findByUserId(userId).isPresent()) {
            throw new IllegalStateException("Profile already exists.");
        }

        Profiles profile = new Profiles();
        profile.setUserId(userId);
        profile.setBirthDate(dto.getBirthDate());
        profile.setGender(dto.getGender());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setAddress(dto.getAddress());
        profile.setSummary(dto.getSummary());

        profilesRepository.save(profile);
    }


    private ProfileDTO mapToDTO(Profiles profile) {
        ProfileDTO dto = new ProfileDTO();
        dto.setBirthDate(profile.getBirthDate());
        dto.setGender(profile.getGender());
        dto.setPhoneNumber(profile.getPhoneNumber());
        dto.setAddress(profile.getAddress());
        dto.setSummary(profile.getSummary());
        return dto;
    }
}
