package com.example.taskmanager;

import jakarta.validation.constraints.NotBlank;

/**
 * TaskRequest
 */
public record TaskRequest(
    @NotBlank 
    String title,
    boolean completed
) {
}
