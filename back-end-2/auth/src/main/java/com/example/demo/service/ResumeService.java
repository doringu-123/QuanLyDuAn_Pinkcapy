package com.example.demo.service;

import com.example.demo.dto.ResumeRequest;
import com.example.demo.dto.ResumeResponse;
import com.example.demo.entity.Resume;
import com.example.demo.entity.User;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private UserRepository userRepository;

    private final String uploadDir = "uploads/resumes/"; // Thư mục lưu file PDF

    public ResumeResponse createResume(ResumeRequest request) throws IOException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getRole().equals(User.Role.Candidate)) {
            throw new RuntimeException("Only candidates can create resumes");
        }

        // Lưu file PDF
        MultipartFile file = request.getFile();
        if (!file.getContentType().equals("application/pdf")) {
            throw new RuntimeException("Only PDF files are allowed");
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());

        Resume resume = new Resume();
        resume.setUser(user);
        resume.setTitle(request.getTitle());
        resume.setContent(filePath.toString());
        resume = resumeRepository.save(resume);

        return mapToResponse(resume);
    }

    public void deleteResume(Integer resumeId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        if (!resume.getUser().getUserId().equals(user.getUserId())) {
            throw new RuntimeException("You can only delete your own resume");
        }

        // Xóa file PDF
        try {
            Files.deleteIfExists(Paths.get(resume.getContent()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete resume file", e);
        }

        resumeRepository.delete(resume);
    }

    public List<ResumeResponse> getResumes() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return resumeRepository.findByUserUserId(user.getUserId())
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ResumeResponse getResume(Integer resumeId) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        if (!resume.getUser().getUserId().equals(user.getUserId())) {
            throw new RuntimeException("You can only view your own resume");
        }

        return mapToResponse(resume);
    }

    private ResumeResponse mapToResponse(Resume resume) {
        ResumeResponse response = new ResumeResponse();
        response.setResumeId(resume.getResumeId());
        response.setUserId(resume.getUser().getUserId());
        response.setTitle(resume.getTitle());
        response.setContent(resume.getContent());
        response.setCreatedAt(resume.getCreatedAt());
        return response;
    }
}