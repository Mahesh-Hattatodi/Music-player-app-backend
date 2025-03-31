package com.example.musicPlayerApi.fav_song.controller;

import com.example.musicPlayerApi.fav_song.model.entity.FavouriteSongEntity;
import com.example.musicPlayerApi.fav_song.service.FavouriteSongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fav-song")
@RequiredArgsConstructor
public class FavouriteSongController {

    private final FavouriteSongService favouriteSongService;

    @PostMapping("/save")
    public ResponseEntity<FavouriteSongEntity> saveFavouriteSong(@RequestBody FavouriteSongEntity favouriteSong) {
        return favouriteSongService.saveFavouriteSong(favouriteSong);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFavouriteSong(@PathVariable String id) {
        favouriteSongService.deleteFavouriteSong(id);
        return ResponseEntity.ok("Deleted song with id " + id);
    }

    @GetMapping("/all-fav-song")
    public ResponseEntity<List<FavouriteSongEntity>> getAllFavouriteSong() {
        return favouriteSongService.getAllFavouriteSong();
    }
}
