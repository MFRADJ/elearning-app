package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
