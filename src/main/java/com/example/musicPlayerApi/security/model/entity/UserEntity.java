package com.example.musicPlayerApi.security.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    @Column(name = "user_password", nullable = false)
    private String userPassword;
    @Column(nullable = false, unique = true)
    private String email;
    @Lob
    @Column(name = "display_image", columnDefinition = "MEDIUMBLOB")
    private byte[] displayImage;

    @Column(name = "is_email_verified", nullable = false)
    private boolean isEmailVerified;

}
