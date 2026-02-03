package com.anh.incident_tracker.dto;

import com.anh.incident_tracker.entity.Priority;

public record IncidentSuggestion(
    Priority priority,
    String category,
    String reasoning
) {}
