package com.example.gateway.controller.collabservice;

import com.example.gateway.dto.request.collabservice.StartSessionRequest;
import com.example.gateway.dto.response.collabservice.ListSessionResponse;
import com.example.gateway.dto.response.collabservice.SessionResponse;
import com.example.gateway.service.CollabServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
@CrossOrigin
public class CollabController {
    private final CollabServiceClient collabServiceClient;

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping("/all/{id}")
    public ResponseEntity<ListSessionResponse> getActiveSessions(@PathVariable("id") UUID documentId) {
        return collabServiceClient.getActiveSessions(documentId);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping("/delete/{id}")
    public ResponseEntity<SessionResponse> endSession(@PathVariable("id") UUID sessionId) {
        return collabServiceClient.endSession(sessionId);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping("/create")
    public ResponseEntity<SessionResponse> createSession(@RequestBody StartSessionRequest request) {
        return collabServiceClient.startSession(request);
    }
}
