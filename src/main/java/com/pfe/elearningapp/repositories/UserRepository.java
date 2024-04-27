package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
