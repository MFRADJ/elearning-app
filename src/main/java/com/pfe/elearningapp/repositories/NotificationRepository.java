package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
