package com.example.gateway.controller.userservice;

import com.example.gateway.dto.request.userservice.UpdatePasswordRequest;
import com.example.gateway.dto.request.userservice.UpdateUserRequest;
import com.example.gateway.dto.response.userservice.ListUserResponse;
import com.example.gateway.dto.response.userservice.UserDetailsResponse;
import com.example.gateway.dto.response.userservice.UserResponse;
import com.example.gateway.service.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserServiceClient userService;

    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/get")
    public ResponseEntity<UserResponse> getUserById(@RequestHeader("Authorization") String token) {
        return userService.getUserById(token);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/all")
    public ResponseEntity<ListUserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PreAuthorize("hasAnyRole('USER')")
    @DeleteMapping
    public ResponseEntity<UserResponse> deleteUser(@RequestHeader("Authorization") String token) {
        return userService.deleteUser(token);
    }


    @PreAuthorize("hasAnyRole('USER')")
    @PutMapping
    public ResponseEntity<UserResponse> updateUser(
            @RequestBody UpdateUserRequest updateUserRequest,
            @RequestHeader("Authorization") String token) {
        return userService.updateUser(updateUserRequest, token);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PutMapping("/password")
    public ResponseEntity<UserResponse> updatePassword(
            @RequestBody UpdatePasswordRequest updateUserRequest,
            @RequestHeader("Authorization") String token) {
        return userService.updatePassword(updateUserRequest, token);
    }

}
