package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
