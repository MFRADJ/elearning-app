package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;  // Le quiz auquel appartient la question

    @Column(nullable = false)
    private String text;  // Texte de la question

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;  // Liste des réponses possibles à la question
}
