package com.example.musicPlayerApi.album_artist.controller;

import com.example.musicPlayerApi.album.model.entity.AlbumEntity;
import com.example.musicPlayerApi.album_artist.model.entity.AlbumArtist;
import com.example.musicPlayerApi.album_artist.service.AlbumArtistService;
import com.example.musicPlayerApi.artist.model.entity.ArtistEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album-artist")
@RequiredArgsConstructor
public class AlbumArtistController {

    private final AlbumArtistService albumArtistService;

    @GetMapping("/album/{albumId}")
    public List<AlbumArtist> getArtistsByAlbum(@PathVariable AlbumEntity albumId) {
        return albumArtistService.getArtistsByAlbum(albumId);
    }

    @GetMapping("/artist/{artistId}")
    public List<AlbumArtist> getAlbumsByArtist(@PathVariable ArtistEntity artistId) {
        return albumArtistService.getAlbumsByArtist(artistId);
    }

    @PostMapping
    public AlbumArtist addArtistToAlbum(@RequestBody AlbumArtist albumArtist) {
        return albumArtistService.addArtistToAlbum(albumArtist);
    }

    @DeleteMapping("/{id}")
    public void removeArtistFromAlbum(@PathVariable Long id) {
        albumArtistService.removeArtistFromAlbum(id);
    }
}
