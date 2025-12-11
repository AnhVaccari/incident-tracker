package com.anh.incident_tracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anh.incident_tracker.dto.CreateIncidentRequest;
import com.anh.incident_tracker.dto.StatusUpdateRequest;
import com.anh.incident_tracker.entity.Incident;
import com.anh.incident_tracker.service.IncidentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    // GET /api/incidents - Récupère tous les incidents
    @GetMapping
    public ResponseEntity<List<Incident>> getAllIncidents() {
        List<Incident> incidents = incidentService.getAllIncidents();
        return ResponseEntity.ok(incidents);
    }

    // POST /api/incidents - Créer un nouvel incident
    @PostMapping
    public ResponseEntity<Incident> createIncident(@Valid @RequestBody CreateIncidentRequest request) {
        Incident newIncident = incidentService.createIncident(
                request.getTitle(),
                request.getDescription(),
                request.getPriority());
        return ResponseEntity.ok(newIncident);
    }

    // GET /api/incidents/{id} - Récupérer un incident spécifique
    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        Optional<Incident> incident = incidentService.getIncidentById(id);

        if (incident.isPresent()) {
            return ResponseEntity.ok(incident.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT /api/incidents/{id}/status - Changer le statut d'un incident
    @PutMapping("/{id}/status")
    public ResponseEntity<Incident> changeStatus(@PathVariable Long id, @RequestBody StatusUpdateRequest request) {
        try {
            Incident updatedIncident = incidentService.changeStatus(id, request.getStatus());
            return ResponseEntity.ok(updatedIncident);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // GET /api/incidents/active - Récupérer tous les incidents actifs (non fermés)
    @GetMapping("/active")
    public ResponseEntity<List<Incident>> getActiveIncidents() {
        List<Incident> activeIncidents = incidentService.getActiveIncidents();
        return ResponseEntity.ok(activeIncidents);
    }

}
