package com.example.gateway.dto.response.userservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponse(
        UUID id,
        @JsonProperty("jwt_token") String jwtToken,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        String email
) {
}
