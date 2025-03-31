package com.example.musicPlayerApi.security.service;

import com.example.musicPlayerApi.security.model.UserPrincipal;
import com.example.musicPlayerApi.security.model.entity.UserEntity;
import com.example.musicPlayerApi.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepo userRepo;
    @Autowired
    public UserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUserName(username);

        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }
}
