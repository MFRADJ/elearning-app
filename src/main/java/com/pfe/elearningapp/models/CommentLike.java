package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment_likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;  // Le commentaire liké

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // L'utilisateur qui a liké le commentaire
}
