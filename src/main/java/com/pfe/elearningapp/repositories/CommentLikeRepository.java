package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike,Long> {
}
