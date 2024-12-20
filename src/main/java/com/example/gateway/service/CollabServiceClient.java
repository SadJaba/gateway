package com.example.gateway.service;

import com.example.gateway.dto.request.collabservice.StartSessionRequest;
import com.example.gateway.dto.response.collabservice.ListSessionResponse;
import com.example.gateway.dto.response.collabservice.SessionResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CollabServiceClient {
    ResponseEntity<SessionResponse> startSession(StartSessionRequest request);
    ResponseEntity<ListSessionResponse> getActiveSessions(UUID documentId);
    ResponseEntity<SessionResponse> endSession(UUID sessionId);
}
