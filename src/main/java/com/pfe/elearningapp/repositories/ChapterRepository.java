package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
