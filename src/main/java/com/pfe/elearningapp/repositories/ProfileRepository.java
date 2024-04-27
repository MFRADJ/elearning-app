package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository <Profile, Long> {
}
