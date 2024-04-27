package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "seances")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @Column(nullable = false)
    private String liveUrl; // URL pour la session live

    @Column(nullable = false)
    private Boolean isAvailable = true; // Indique si la séance est disponible pour inscription

    @OneToOne(mappedBy = "seance", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private CalendarEvent calendarEvent;

    // Constructors, getters and setters
}
