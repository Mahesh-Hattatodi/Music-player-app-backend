package com.example.musicPlayerApi.playlist.service;

import com.example.musicPlayerApi.playlist.model.entity.PlaylistEntity;
import com.example.musicPlayerApi.playlist.repo.PlayListRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayListService {

    private final PlayListRepo playListRepo;

    public ResponseEntity<PlaylistEntity> savePlayList(PlaylistEntity playlist) {
        PlaylistEntity savedPlaylistEntity = playListRepo.save(playlist);
        return ResponseEntity.ok(savedPlaylistEntity);
    }

    public ResponseEntity<String> deletePlayList(String playlistId) {
        PlaylistEntity playlistEntity = playListRepo.getReferenceById(playlistId);
        playListRepo.delete(playlistEntity);
        return ResponseEntity.ok("Deleted playlist with the id " + playlistId);
    }

    public ResponseEntity<List<PlaylistEntity>> allPlayList() {
        return ResponseEntity.ok(playListRepo.findAll());
    }
}
