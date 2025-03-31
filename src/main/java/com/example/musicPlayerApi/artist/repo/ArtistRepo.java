package com.example.musicPlayerApi.artist.repo;

import com.example.musicPlayerApi.artist.model.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepo extends JpaRepository<ArtistEntity, String> {
}
