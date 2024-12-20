package com.example.gateway.dto.response.userservice;

import java.util.List;

public record ListUserResponse(
        List<UserResponse> users
) {
}
