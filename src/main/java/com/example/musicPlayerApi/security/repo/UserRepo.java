package com.example.musicPlayerApi.security.repo;

import com.example.musicPlayerApi.security.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String userName);

    UserEntity findByEmail(String email);
}
