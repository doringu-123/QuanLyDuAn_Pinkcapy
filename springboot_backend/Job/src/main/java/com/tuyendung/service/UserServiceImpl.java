package com.tuyendung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tuyendung.dto.LoginDTO;
import com.tuyendung.dto.UserDTO;
import com.tuyendung.entity.User;
import com.tuyendung.repository.UserRepository;
import com.tuyendung.utility.Utilities;

import jakarta.validation.Valid;

import com.tuyendung.exception.JobPortalException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) throws JobPortalException {
        Optional<User> optional = userRepository.findByEmail(userDTO.getEmail());
        if (optional.isPresent()) throw new JobPortalException("USER_FOUND");
        
        // Mã hóa mật khẩu trước khi lưu
        //userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        
        User user = userDTO.toEntity();
        user = userRepository.save(user);
        return user.toDTO();
    }


    @Override
    public UserDTO loginUser(LoginDTO loginDTO) throws JobPortalException {
        // Tìm người dùng theo email
        User user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new JobPortalException("USER_NOT_FOUND"));
        
        // So sánh trực tiếp mật khẩu
        if (!loginDTO.getPassword().equals(user.getPassword())) {
            throw new JobPortalException("INVALID_CREDENTIALS");
        }
        
        // Trả về thông tin người dùng
        return user.toDTO();
    }
}
