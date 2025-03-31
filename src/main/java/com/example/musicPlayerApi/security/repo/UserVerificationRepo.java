package com.example.musicPlayerApi.security.repo;

import com.example.musicPlayerApi.security.model.entity.EmailVerificationSecureToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVerificationRepo extends JpaRepository<EmailVerificationSecureToken, Long> {
    EmailVerificationSecureToken findByEmail(String email);
    @Query("SELECT v.isVerified FROM EmailVerificationSecureToken v WHERE v.email = :email")
    Boolean findIsVerifiedByEmail(String email);
}
