package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.MessageAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageAttachmentRepository extends JpaRepository<MessageAttachment, Long> {
}
