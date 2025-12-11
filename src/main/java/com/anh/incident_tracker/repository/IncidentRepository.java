package com.anh.incident_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anh.incident_tracker.entity.Incident;
import com.anh.incident_tracker.entity.Priority;
import com.anh.incident_tracker.entity.Status;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    // Méthodes de recherche personnalisées
    List<Incident> findByStatus(Status status);

    List<Incident> findByPriority(Priority priority);

    List<Incident> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT i FROM Incident i WHERE i.status IN ('OPEN', 'IN_PROGRESS')")
    List<Incident> findActiveIncidents();

}
