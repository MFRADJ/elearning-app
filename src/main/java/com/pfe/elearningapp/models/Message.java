package com.pfe.elearningapp.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;


@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Message.findBySender",
                query = "SELECT m FROM Message m WHERE m.sender.id = :senderId"),
        @NamedQuery(name = "Message.findByReceiver",
                query = "SELECT m FROM Message m WHERE m.receiver.id = :receiverId")
})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;  // L'expéditeur du message

    @ManyToMany
    @JoinTable(
            name = "message_receivers",
            joinColumns = @JoinColumn(name = "message_id"),
            inverseJoinColumns = @JoinColumn(name = "receiver_id")
    )
    private List<User> receivers;  // Les destinataires du message, permettant les discussions de groupe

    @Column(nullable = false)
    private String content;  // Le contenu du message

    @Column(nullable = false)
    private LocalDateTime sentTime;  // Le timestamp de l'envoi du message

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageAttachment> attachments;  // Les pièces jointes
}
