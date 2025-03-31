package com.example.musicPlayerApi.fav_song.service;

import com.example.musicPlayerApi.fav_song.model.entity.FavouriteSongEntity;
import com.example.musicPlayerApi.fav_song.repo.FavouriteSongRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavouriteSongService {

    private final FavouriteSongRepo favouriteSongRepo;

    public ResponseEntity<FavouriteSongEntity> saveFavouriteSong(FavouriteSongEntity favouriteSong) {
        return ResponseEntity.ok(favouriteSongRepo.save(favouriteSong));
    }

    public void deleteFavouriteSong(String songId) {
        FavouriteSongEntity favouriteSong = favouriteSongRepo.getReferenceById(songId);
        favouriteSongRepo.delete(favouriteSong);
    }

    public ResponseEntity<List<FavouriteSongEntity>> getAllFavouriteSong() {
        return ResponseEntity.ok(favouriteSongRepo.findAll());
    }
}
