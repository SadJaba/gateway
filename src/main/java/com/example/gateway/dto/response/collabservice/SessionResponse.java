package com.example.gateway.dto.response.collabservice;

import java.time.LocalDateTime;
import java.util.UUID;

public record SessionResponse(
    UUID sessionId,
    UUID documentId,
    String userId,
    LocalDateTime startTime
) {
}
