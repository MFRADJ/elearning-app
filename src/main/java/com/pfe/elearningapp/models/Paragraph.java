package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "paragraphs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;  // La section à laquelle appartient le paragraphe

    @Column(nullable = false)
    private String text;  // Texte du paragraphe
}
