package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
