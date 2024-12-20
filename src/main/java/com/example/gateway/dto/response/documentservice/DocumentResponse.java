package com.example.gateway.dto.response.documentservice;

import java.util.UUID;

public record DocumentResponse(
        UUID id,
        String title,
        String content,
        String ownerId,
        boolean isPublic
) {
}
