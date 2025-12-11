package com.anh.incident_tracker.entity;

public enum Priority {
    LOW("Faible"),
    NORMAL("Normale"),
    HIGH("Haute"),
    CRITICAL("Critique");

    private final String displayName;

    Priority(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
