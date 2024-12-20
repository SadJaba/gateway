package com.example.gateway.service.impl;


import com.example.gateway.dto.request.userservice.AuthenticationRequest;
import com.example.gateway.dto.request.userservice.CreateUserRequest;
import com.example.gateway.dto.request.userservice.UpdatePasswordRequest;
import com.example.gateway.dto.request.userservice.UpdateUserRequest;
import com.example.gateway.dto.response.userservice.ListUserResponse;
import com.example.gateway.dto.response.userservice.UserDetailsResponse;
import com.example.gateway.dto.response.userservice.UserResponse;
import com.example.gateway.service.UserServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class UserServiceClientImpl implements UserServiceClient {
    private static final String USER_SERVICE_URL = "http://localhost:8082";


    private final WebClient webClient;

    public UserServiceClientImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(USER_SERVICE_URL)
                .build();
    }
    @Override
    public ResponseEntity<UserResponse> signUp(CreateUserRequest request) {
        var user = webClient
                .post()
                .uri("/auth/signup")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<UserResponse> authenticate(AuthenticationRequest request) {
        var user = webClient
                .post()
                .uri("/auth/signin")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
        return ResponseEntity.ok(user);
    }

    @Override
    public UserDetailsResponse isTokenValid(String token) {
        return webClient
                .get()
                .uri("/auth/verify?token={token}", token)
                .retrieve()
                .bodyToMono(UserDetailsResponse.class)
                .block();
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(String token) {
        var resp = webClient
                .get()
                .uri("/user")
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
        return ResponseEntity.ok().body(resp);
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<ListUserResponse> getAllUsers() {
        var users = webClient
                .get()
                .uri("/user/all")
                .retrieve()
                .bodyToMono(ListUserResponse.class)
                .block();
        return ResponseEntity.ok().body(users);
    }

    @Override
    public ResponseEntity<UserResponse> deleteUser(String token) {
        var user = webClient
                .delete()
                .uri("/user/delete")
                .header("Authorization", token)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
        return ResponseEntity.ok().body(user);
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UpdateUserRequest updateUserRequest, String token) {
        var user = webClient
                .post()
                .uri("/user/update/data")
                .header("Authorization", token)
                .bodyValue(updateUserRequest)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
        return ResponseEntity.ok().body(user);
    }

    @Override
    public ResponseEntity<UserResponse> updatePassword(UpdatePasswordRequest updatePasswordRequest, String token) {
        var user = webClient
                .post()
                .uri("/user/update/password")
                .header("Authorization", token)
                .bodyValue(updatePasswordRequest)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();
        return ResponseEntity.ok().body(user);
    }
}
