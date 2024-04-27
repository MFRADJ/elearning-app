package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
