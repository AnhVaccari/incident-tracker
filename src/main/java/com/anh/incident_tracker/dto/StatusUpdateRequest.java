package com.anh.incident_tracker.dto;

import com.anh.incident_tracker.entity.Status;

import jakarta.validation.constraints.NotNull;

public class StatusUpdateRequest {

    @NotNull(message = "Le statut est obligatoire")
    private Status status;

    // Constructeur par défaut
    public StatusUpdateRequest() {
    }

    // Getter
    public Status getStatus() {
        return status;
    }

    // Setter
    public void setStatus(Status status) {
        this.status = status;
    }

}
