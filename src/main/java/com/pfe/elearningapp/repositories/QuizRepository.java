package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
