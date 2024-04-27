package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
