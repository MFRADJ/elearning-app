package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "sections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chapter_id", nullable = false)
    private Chapter chapter;  // Le chapitre auquel appartient la section

    @Column(nullable = false)
    private String title;  // Titre de la section

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Paragraph> paragraphs;  // Liste des paragraphes de la section

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes;  // Liste des quiz de la section
}
