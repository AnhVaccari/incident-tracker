package com.anh.incident_tracker.dto;

import jakarta.validation.constraints.NotBlank;

public record ClassifyRequest(
    @NotBlank(message = "Le titre est obligatoire")
    String title,

    @NotBlank(message = "La description est obligatoire")
    String description
) {}
