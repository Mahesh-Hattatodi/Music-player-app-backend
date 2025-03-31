package com.example.musicPlayerApi.fav_song.repo;

import com.example.musicPlayerApi.fav_song.model.entity.FavouriteSongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteSongRepo extends JpaRepository<FavouriteSongEntity, String> {
}
