package com.example.musicPlayerApi.album.repo;

import com.example.musicPlayerApi.album.model.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository<AlbumEntity, String> {
}
