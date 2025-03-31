package com.example.musicPlayerApi.playlist.repo;

import com.example.musicPlayerApi.playlist.model.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepo extends JpaRepository<PlaylistEntity, String> {
}
