package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}