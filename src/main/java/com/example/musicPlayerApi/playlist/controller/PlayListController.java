package com.example.musicPlayerApi.playlist.controller;

import com.example.musicPlayerApi.playlist.model.entity.PlaylistEntity;
import com.example.musicPlayerApi.playlist.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
@RequiredArgsConstructor
public class PlayListController {

    private final PlayListService playListService;

    @PostMapping("/save")
    public ResponseEntity<PlaylistEntity> savePlayList(@RequestBody PlaylistEntity playlist) {
        return playListService.savePlayList(playlist);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePlayList(@PathVariable String id) {
        return playListService.deletePlayList(id);
    }

    @GetMapping("/all-playlist")
    public ResponseEntity<List<PlaylistEntity>> getAllPlaylist() {
        return playListService.allPlayList();
    }
}
