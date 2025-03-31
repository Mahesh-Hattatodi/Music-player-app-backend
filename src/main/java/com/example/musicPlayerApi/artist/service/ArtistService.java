package com.example.musicPlayerApi.artist.service;

import com.example.musicPlayerApi.artist.model.entity.ArtistEntity;
import com.example.musicPlayerApi.artist.repo.ArtistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepo artistRepo;

    public List<ArtistEntity> getAllArtists() {
        return artistRepo.findAll();
    }

    public Optional<ArtistEntity> getArtistById(String artistId) {
        return artistRepo.findById(artistId);
    }

    public ArtistEntity saveArtist(ArtistEntity artist) {
        return artistRepo.save(artist);
    }

    public void deleteArtist(String artistId) {
        artistRepo.deleteById(artistId);
    }
}
