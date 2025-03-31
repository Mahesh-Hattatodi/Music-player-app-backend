package com.example.musicPlayerApi.security.service;

import com.example.musicPlayerApi.security.model.entity.EmailVerificationSecureToken;
import com.example.musicPlayerApi.security.repo.UserVerificationRepo;
import com.example.musicPlayerApi.security.util.VerificationCodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VerificationService {

    private final UserVerificationRepo userVerificationRepo;
    private final EmailService emailService;

    public boolean verifyCode(String email, String code) {
        EmailVerificationSecureToken userVerification = userVerificationRepo.findByEmail(email);
        if (userVerification != null && userVerification.getVerificationCode().equals(code)) {
            // Verification successful
            userVerification.setVerified(true);
            userVerificationRepo.save(userVerification);
            return true;
        }
        // Verification failed
        return false;
    }

    public void sendVerificationEmail(String to) {
        String code = VerificationCodeGenerator.generateVerificationCode();
        EmailVerificationSecureToken emailVerificationSecureToken = new EmailVerificationSecureToken();
        emailVerificationSecureToken.setEmail(to);
        emailVerificationSecureToken.setVerificationCode(code);
        emailVerificationSecureToken.setVerified(false);
        userVerificationRepo.save(emailVerificationSecureToken);
        log.debug("Before sending email");
        emailService.sendEmail(to, "Email verification code", "Your verification code is " + code);
    }

    public void resetEmailVerificationToken(String email) {
        String code = VerificationCodeGenerator.generateVerificationCode();
        EmailVerificationSecureToken userVerification = userVerificationRepo.findByEmail(email);
        userVerification.setVerificationCode(code);
        userVerification.setVerified(false);
        userVerificationRepo.save(userVerification);
        emailService.sendEmail(email, "Email verification code", "Your verification code is " + code);
    }

    public boolean isEmailVerified(String email) {
        return userVerificationRepo.findIsVerifiedByEmail(email);
    }

    public void deleteEmailVerificationToken(String email) {
        EmailVerificationSecureToken userVerification = userVerificationRepo.findByEmail(email);
        userVerificationRepo.delete(userVerification);
    }
}
