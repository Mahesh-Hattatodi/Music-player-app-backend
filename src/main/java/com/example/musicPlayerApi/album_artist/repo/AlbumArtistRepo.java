package com.example.musicPlayerApi.album_artist.repo;

import com.example.musicPlayerApi.album.model.entity.AlbumEntity;
import com.example.musicPlayerApi.album_artist.model.entity.AlbumArtist;
import com.example.musicPlayerApi.artist.model.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumArtistRepo extends JpaRepository<AlbumArtist, Long> {

    // Fetch all artists associated with a given album
    List<AlbumArtist> findByAlbum(AlbumEntity album);

    // Fetch all albums associated with a given artist
    List<AlbumArtist> findByArtist(ArtistEntity artist);
}
