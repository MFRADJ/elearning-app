package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
