package com.example.gateway.dto.request.collabservice;

import java.util.UUID;

public record StartSessionRequest(
        UUID documentId,
        String userId
) {
}
