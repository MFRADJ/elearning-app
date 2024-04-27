package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.CourseActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseActivityRepository extends JpaRepository<CourseActivity, Long> {
}