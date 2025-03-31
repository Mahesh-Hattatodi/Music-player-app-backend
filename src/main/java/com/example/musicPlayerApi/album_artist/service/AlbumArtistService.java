package com.example.musicPlayerApi.album_artist.service;

import com.example.musicPlayerApi.album.model.entity.AlbumEntity;
import com.example.musicPlayerApi.album_artist.model.entity.AlbumArtist;
import com.example.musicPlayerApi.album_artist.repo.AlbumArtistRepo;
import com.example.musicPlayerApi.artist.model.entity.ArtistEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumArtistService {

    private final AlbumArtistRepo albumArtistRepo;

    public List<AlbumArtist> getArtistsByAlbum(AlbumEntity album) {
        return albumArtistRepo.findByAlbum(album);
    }

    public List<AlbumArtist> getAlbumsByArtist(ArtistEntity artist) {
        return albumArtistRepo.findByArtist(artist);
    }

    public AlbumArtist addArtistToAlbum(AlbumArtist albumArtist) {
        return albumArtistRepo.save(albumArtist);
    }

    public void removeArtistFromAlbum(Long id) {
        albumArtistRepo.deleteById(id);
    }
}
