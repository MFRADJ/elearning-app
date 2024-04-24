package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "quizzes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;  // La section à laquelle appartient le quiz

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;  // Liste des questions du quiz
}
