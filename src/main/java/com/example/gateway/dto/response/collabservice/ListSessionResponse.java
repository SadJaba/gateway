package com.example.gateway.dto.response.collabservice;

import java.util.List;

public record ListSessionResponse(
        List<SessionResponse> sessions
) {
}
