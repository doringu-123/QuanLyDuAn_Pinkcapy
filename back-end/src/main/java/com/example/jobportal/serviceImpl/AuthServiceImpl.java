package com.example.jobportal.serviceImpl;

import com.example.jobportal.dto.AuthRequest;
import com.example.jobportal.dto.AuthResponse;
import com.example.jobportal.dto.RegisterRequest;
import com.example.jobportal.model.entity.PasswordResetToken;
import com.example.jobportal.model.entity.Users;
import com.example.jobportal.repository.PasswordResetTokenRepository;
import com.example.jobportal.repository.UserRepository;
import com.example.jobportal.security.JwtUtils;
import com.example.jobportal.service.AuthService;
import com.example.jobportal.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordResetTokenRepository resetTokenRepo;
    private final EmailUtil emailUtil;
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Override
    public AuthResponse register(RegisterRequest request) {
        Users user = new Users();
        user.setFullName(request.fullName);
        user.setEmail(request.email);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setRole(com.example.jobportal.model.enums.Role.valueOf(request.role.toUpperCase()));
        user.setStatus(com.example.jobportal.model.enums.Status.ACTIVE);
        userRepo.save(user);

        String token = jwtUtils.generateToken(user.getEmail());
        return new AuthResponse(token, user.getRole().name());
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        Users user = userRepo.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(user.getEmail());
        return new AuthResponse(token, user.getRole().name());
    }
    @Override
    public void forgotPassword(String email) {
        Users user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken(null, token, email,
                LocalDateTime.now().plusMinutes(30));
        resetTokenRepo.save(resetToken);

        String link = "http://localhost:8080/api/auth/reset-password?token=" + token;
        emailUtil.sendEmail(email, "Đặt lại mật khẩu", "Click vào link: " + link);
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken reset = resetTokenRepo.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token không hợp lệ"));

        if (reset.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token đã hết hạn");
        }

        Users user = userRepo.findByEmail(reset.getEmail())
                .orElseThrow(() -> new RuntimeException("User không tồn tại"));

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);

        resetTokenRepo.delete(reset);
    }

}
