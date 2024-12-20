package com.example.gateway.dto.response.documentservice;

import java.time.LocalDateTime;
import java.util.UUID;

public record DocumentVersionResponse (
        UUID id,
        String content,
        LocalDateTime timestamp
){
}
