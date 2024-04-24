package com.pfe.elearningapp.models;

import com.pfe.elearningapp.enmus.NotificationType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Utilisateur destinataire de la notification

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationType type;  // Type de la notification (ex. MESSAGE, REMINDER, UPDATE)

    @Column(nullable = false)
    private String content;  // Contenu de la notification

    @Column(nullable = false)
    private LocalDateTime notifyTime;  // Heure à laquelle la notification a été envoyée

    @Column(nullable = false)
    private boolean isRead = false;  // Statut de lecture de la notification


}
