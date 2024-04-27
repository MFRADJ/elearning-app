package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;  // Référence au commentaire parent, null si c'est un commentaire principal

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> replies;  // Liste des réponses à ce commentaire

    @Column(nullable = false)
    private String text;  // Texte du commentaire

    @Column(nullable = false)
    private LocalDateTime postedAt;  // Timestamp du commentaire

    @Column(nullable = false)
    private int likeCount = 0;  // Nombre de "likes" pour ce commentaire
}
