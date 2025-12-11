package com.anh.incident_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anh.incident_tracker.entity.Incident;
import com.anh.incident_tracker.entity.Priority;
import com.anh.incident_tracker.entity.Status;
import com.anh.incident_tracker.repository.IncidentRepository;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    // Créer un nouvel incident
    public Incident createIncident(String title, String description, Priority priority) {
        Incident incident = new Incident();
        incident.setTitle(title);
        incident.setDescription(description);
        incident.setPriority(priority);
        // Le statut et les dates sont déjà définis dans le constructeur

        return incidentRepository.save(incident);
    }

    // Récupérer tous les incidents
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    // Récupérer un incident par son ID
    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    // Changer le statut d'un incident
    public Incident changeStatus(Long id, Status newStatus) {
        Optional<Incident> optionalIncident = incidentRepository.findById(id);

        if (optionalIncident.isPresent()) {
            Incident incident = optionalIncident.get();

            // LOGIQUE MÉTIER : Vérifier que le changement est logique
            if (incident.getStatus() == Status.CLOSED) {
                throw new IllegalStateException("Impossible de modifier un incident fermé !");
            }

            incident.setStatus(newStatus);
            // setStatus() met automatiquement à jour updatedAt grâce à setter

            return incidentRepository.save(incident);
        } else {
            throw new IllegalArgumentException("Incident avec l'ID " + id + " introuvable !");
        }

    }

    // Récupérer tous les incidents non fermés (actifs)
    public List<Incident> getActiveIncidents() {
        return incidentRepository.findActiveIncidents();
    }

    // Récupérer par priorité
    public List<Incident> getIncidentsByPriority(Priority priority) {
        return incidentRepository.findByPriority(priority);
    }

}
