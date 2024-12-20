package com.example.gateway.controller.userservice;

import com.example.gateway.dto.request.userservice.AuthenticationRequest;
import com.example.gateway.dto.request.userservice.CreateUserRequest;
import com.example.gateway.dto.response.userservice.UserResponse;
import com.example.gateway.service.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    private final UserServiceClient userServiceClient;

    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUp(@RequestBody CreateUserRequest createUserRequest) {
        return userServiceClient.signUp(createUserRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserResponse> authenticate(@RequestBody AuthenticationRequest createUserRequest) {
        return userServiceClient.authenticate(createUserRequest);
    }

}
