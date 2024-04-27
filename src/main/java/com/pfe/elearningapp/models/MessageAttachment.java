package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "message_attachments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    private Message message;  // Le message auquel l'attachement est associé

    @Column(nullable = false)
    private String fileName;  // Le nom du fichier attaché

    @Column(nullable = false)
    private String filePath;  // Le chemin d'accès au fichier stocké

    @Column(nullable = false)
    private long fileSize;  // La taille du fichier
}
