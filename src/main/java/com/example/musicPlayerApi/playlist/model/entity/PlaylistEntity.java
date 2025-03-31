package com.example.musicPlayerApi.playlist.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaylistEntity {

    @Id
    private String playListId;
    @Column
    private String playListName;
    @Column(name = "low_image_quality_url")
    private String lowImageResUrl;
    @Column(name = "medium_image_quality_url")
    private String mediumImageResUrl;
    @Column(name = "high_image_quality_url")
    private String highImageResUrl;
    @Column(name = "song_count")
    private int songCount;
    @Column
    private String language;
}
