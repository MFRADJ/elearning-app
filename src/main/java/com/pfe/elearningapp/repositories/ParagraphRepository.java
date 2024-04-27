package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
}
