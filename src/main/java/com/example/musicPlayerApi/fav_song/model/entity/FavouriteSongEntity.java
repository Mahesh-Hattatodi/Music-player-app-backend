package com.example.musicPlayerApi.fav_song.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteSongEntity {

    @Id
    private String songId;
    @Column
    private String songName;
    @Column
    private String year;
    @Column
    private int duration;
    @Column
    private String label;
    @Column
    private int  playCount;
    @Column
    private String songLanguage;
    @Column(name = "low_image_quality_url")
    private String lowImageResUrl;
    @Column(name = "medium_image_quality_url")
    private String mediumImageResUrl;
    @Column(name = "high_image_quality_url")
    private String highImageResUrl;
    @Column(name = "very_low_quality_song_url")
    private String veryLowQualitySongUrl;
    @Column(name = "low_quality_song_url")
    private String lowQualitySongUrl;
    @Column(name = "medium_quality_song_url")
    private String mediumQualitySongUrl;
    @Column(name = "high_quality_song_url")
    private String highQualitySongUrl;
    @Column(name = "very_high_quality_song_url")
    private String veryHighQualitySongUrl;

}
