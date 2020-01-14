package com.mnt.eventsplanning.api.repositories;

import com.mnt.eventsplanning.api.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Events, Long> {
}
