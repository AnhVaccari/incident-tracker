package com.anh.incident_tracker.entity;

public enum Status {
    OPEN("Ouvert"),
    IN_PROGRESS("En cours"),
    RESOLVED("Résolu"),
    CLOSED("Fermé");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
