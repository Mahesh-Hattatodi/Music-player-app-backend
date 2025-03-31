package com.example.musicPlayerApi.security.service;

import com.example.musicPlayerApi.security.model.entity.UserEntity;
import com.example.musicPlayerApi.security.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final VerificationService verificationService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public void register(
            UserEntity user,
            MultipartFile imageFile
    ) throws IOException {
        if (verificationService.isEmailVerified(user.getEmail())) {
            user.setUserPassword(encoder.encode(user.getUserPassword()));
            user.setDisplayImage(imageFile.getBytes());
            user.setEmailVerified(true);
            userRepo.save(user);

            verificationService.deleteEmailVerificationToken(user.getEmail());
        }
    }

    public ResponseEntity<Map<String, String>> verify(UserEntity user) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUserName(), user.getUserPassword())
                );

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(user.getUserName());

            // Return JSON response
            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
