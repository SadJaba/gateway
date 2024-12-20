package com.example.gateway.dto.request.userservice;

public record AuthenticationRequest(
        String email,
        String password
) {
}
