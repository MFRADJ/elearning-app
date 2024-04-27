package com.pfe.elearningapp.repositories;

import com.pfe.elearningapp.models.CalendarEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Long> {
}
