package com.example.musicPlayerApi.security.service;

import com.example.musicPlayerApi.security.model.ForgotPassword;
import com.example.musicPlayerApi.security.model.entity.UserEntity;
import com.example.musicPlayerApi.security.repo.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ForgotPasswordService {

    private final VerificationService verificationService;
    private final UserRepo userRepo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void resetPassword(ForgotPassword forgotPassword) {
        System.out.println(forgotPassword.getEmail() + " " + forgotPassword.getPassword());
        if (verificationService.isEmailVerified(forgotPassword.getEmail())) {
            UserEntity user = userRepo.findByEmail(forgotPassword.getEmail());

            if (user != null) {
                user.setUserPassword(encoder.encode(forgotPassword.getPassword()));
                userRepo.save(user);
                verificationService.deleteEmailVerificationToken(forgotPassword.getEmail());
            } else {
                throw new EntityNotFoundException("User not found for the email " + forgotPassword.getEmail());
            }
        } else {
            throw new RuntimeException("Email is not verified");
        }
    }
}
