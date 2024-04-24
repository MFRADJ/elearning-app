package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;  // La question à laquelle appartient la réponse

    @Column(nullable = false)
    private String text;  // Texte de la réponse

    @Column(nullable = false)
    private boolean isCorrect;  // Indique si la réponse est correcte ou non
}
