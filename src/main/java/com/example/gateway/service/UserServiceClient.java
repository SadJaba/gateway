package com.example.gateway.service;

import com.example.gateway.dto.request.userservice.AuthenticationRequest;
import com.example.gateway.dto.request.userservice.CreateUserRequest;
import com.example.gateway.dto.request.userservice.UpdatePasswordRequest;
import com.example.gateway.dto.request.userservice.UpdateUserRequest;
import com.example.gateway.dto.response.userservice.ListUserResponse;
import com.example.gateway.dto.response.userservice.UserDetailsResponse;
import com.example.gateway.dto.response.userservice.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserServiceClient {
    ResponseEntity<UserResponse> signUp(CreateUserRequest createUserRequest);

    ResponseEntity<UserResponse> authenticate(AuthenticationRequest request);

    UserDetailsResponse isTokenValid(String token);
    ResponseEntity<UserResponse> getUserById(String token);

    ResponseEntity<UserResponse> getUserById(UUID id);

    ResponseEntity<ListUserResponse> getAllUsers();

    ResponseEntity<UserResponse> deleteUser(String token);

    ResponseEntity<UserResponse> updateUser(UpdateUserRequest updateUserRequest, String token);

    ResponseEntity<UserResponse> updatePassword(UpdatePasswordRequest updatePasswordRequest, String token);
}
