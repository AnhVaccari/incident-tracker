package com.anh.incident_tracker.service;

import com.anh.incident_tracker.ai.IncidentClassifier;
import com.anh.incident_tracker.dto.IncidentSuggestion;
import com.anh.incident_tracker.entity.Priority;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final IncidentClassifier incidentClassifier;
    private final ObjectMapper objectMapper;

    public AiService(IncidentClassifier incidentClassifier) {
        this.incidentClassifier = incidentClassifier;
        this.objectMapper = new ObjectMapper();
    }

    public IncidentSuggestion classifyIncident(String title, String description) {
        String response = incidentClassifier.classify(title, description);

        try {
            JsonNode json = objectMapper.readTree(response);

            Priority priority = Priority.valueOf(json.get("priority").asText().toUpperCase());
            String category = json.get("category").asText();
            String reasoning = json.get("reasoning").asText();

            return new IncidentSuggestion(priority, category, reasoning);
        } catch (Exception e) {
            // Fallback en cas d'erreur de parsing
            return new IncidentSuggestion(Priority.NORMAL, "AUTRE",
                "Impossible d'analyser automatiquement. Erreur: " + e.getMessage());
        }
    }
}
