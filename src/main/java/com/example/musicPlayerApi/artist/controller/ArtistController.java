package com.example.musicPlayerApi.artist.controller;

import com.example.musicPlayerApi.artist.model.entity.ArtistEntity;
import com.example.musicPlayerApi.artist.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artist")
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    public List<ArtistEntity> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public Optional<ArtistEntity> getArtistById(@PathVariable String id) {
        return artistService.getArtistById(id);
    }

    @PostMapping
    public ArtistEntity createArtist(@RequestBody ArtistEntity artist) {
        return artistService.saveArtist(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable String id) {
        artistService.deleteArtist(id);
    }
}
