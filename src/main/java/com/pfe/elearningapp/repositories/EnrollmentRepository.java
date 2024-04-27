package com.pfe.elearningapp.repositories;
import com.pfe.elearningapp.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{

}