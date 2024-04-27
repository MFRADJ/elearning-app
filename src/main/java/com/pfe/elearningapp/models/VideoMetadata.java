package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "video_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @Column(nullable = false)
    private long viewCount;  // Nombre de vues

    @Column(nullable = false)
    private long averageWatchDurationInSeconds;  // Durée moyenne de visionnage en secondes
}
