package com.example.musicPlayerApi.album.model.entity;

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
public class AlbumEntity {

    @Id
    private String albumId;
    @Column
    private String albumName;
    @Column
    private String year;
    @Column(name = "low_image_quality_url")
    private String lowImageResUrl;
    @Column(name = "medium_image_quality_url")
    private String mediumImageResUrl;
    @Column(name = "high_image_quality_url")
    private String highImageResUrl;
    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<AlbumArtist> albumArtists;
}
