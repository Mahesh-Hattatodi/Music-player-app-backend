package com.example.musicPlayerApi.album.service;

import com.example.musicPlayerApi.album.model.entity.AlbumEntity;
import com.example.musicPlayerApi.album.repo.AlbumRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepo albumRepo;

    public List<AlbumEntity> getAllAlbums() {
        return albumRepo.findAll();
    }

    public Optional<AlbumEntity> getAlbumById(String albumId) {
        return albumRepo.findById(albumId);
    }

    public AlbumEntity saveAlbum(AlbumEntity album) {
        return albumRepo.save(album);
    }

    public void deleteAlbum(String albumId) {
        albumRepo.deleteById(albumId);
    }
}
