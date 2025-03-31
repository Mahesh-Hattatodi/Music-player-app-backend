package com.example.musicPlayerApi.security.controller;

import com.example.musicPlayerApi.security.model.ForgotPassword;
import com.example.musicPlayerApi.security.model.entity.UserEntity;
import com.example.musicPlayerApi.security.service.ForgotPasswordService;
import com.example.musicPlayerApi.security.service.UserService;
import com.example.musicPlayerApi.security.service.VerificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;
    private final ObjectMapper objectMapper;
    private final VerificationService verificationService;
    private final ForgotPasswordService forgotPasswordService;

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> register(
            @RequestPart("user") String userJson,
            @RequestPart("imageFile") MultipartFile imageFile
    ) {

        try {

            UserEntity user = objectMapper.readValue(userJson, UserEntity.class);

            userService.register(user, imageFile);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error registering user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserEntity user) {
        return userService.verify(user);
    }

    @PostMapping("/send_verification_email")
    public ResponseEntity<String> sendVerificationEmail(@RequestParam String email) {
        try {
            verificationService.sendVerificationEmail(email);
            return ResponseEntity.ok("Verification email sent successfully");
        } catch (Exception e) {
            log.error("Error while sending verification email to the email " + email + " with the exception " + e);
            return ResponseEntity.badRequest().body("Verification email not sent");
        }
    }

    @PostMapping("/verify_code")
    public ResponseEntity<String> verifyCode(@RequestParam String email, @RequestParam String code) {
        try {
            if (verificationService.verifyCode(email, code)) {
                return ResponseEntity.ok("Code is verified");
            }

            return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION).body("Check the sent code");
        } catch (Exception e) {
            log.error("Error while verifying the code " + code + " for the email " + email + " with the exception " + e);
            return ResponseEntity.badRequest().body("Code verification failed");
        }
    }

    @PostMapping("/reset_verification_token")
    public ResponseEntity<String> resetToken(@RequestParam String email) {
        try {
            verificationService.resetEmailVerificationToken(email);
            return ResponseEntity.ok().body("Verification code is reset for the email " + email);
        } catch (Exception e) {
            log.error("Error while resetting token for the email " + email + " with the exception " + e);
            return ResponseEntity.badRequest().body("Couldn't reset verification code for the email " + email);
        }
    }

    @PostMapping("/forgot_password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPassword forgotPassword) {
        try {
            forgotPasswordService.resetPassword(forgotPassword);
            return ResponseEntity.ok("Password reset successful");
        } catch (Exception e) {
            log.error("Error while resetting the password");
            return ResponseEntity.badRequest().body("Error while resetting password " + e);
        }
    }
}
