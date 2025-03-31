package com.example.musicPlayerApi.album.controller;

import com.example.musicPlayerApi.album.model.entity.AlbumEntity;
import com.example.musicPlayerApi.album.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/album")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public List<AlbumEntity> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public Optional<AlbumEntity> getAlbumById(@PathVariable String id) {
        return albumService.getAlbumById(id);
    }

    @PostMapping
    public AlbumEntity createAlbum(@RequestBody AlbumEntity album) {
        return albumService.saveAlbum(album);
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable String id) {
        albumService.deleteAlbum(id);
    }
}
