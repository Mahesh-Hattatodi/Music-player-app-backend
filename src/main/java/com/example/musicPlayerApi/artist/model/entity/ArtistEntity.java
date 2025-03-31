package com.example.musicPlayerApi.artist.model.entity;

import com.example.musicPlayerApi.album_artist.model.entity.AlbumArtist;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistEntity {

    @Id
    private String artistId;
    @Column
    private String artistName;
    @Column
    private String artistRole;
    @Column(name = "low_image_quality_url")
    private String lowImageResUrl;
    @Column(name = "medium_image_quality_url")
    private String mediumImageResUrl;
    @Column(name = "high_image_quality_url")
    private String highImageResUrl;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlbumArtist> albumArtists;
}
