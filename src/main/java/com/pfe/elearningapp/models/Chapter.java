package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "chapters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;  // Le cours auquel appartient le chapitre

    @Column(nullable = false)
    private String title;  // Titre du chapitre

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections;  // Liste des sections du chapitre
}
