package com.example.gateway.service.impl;

import com.example.gateway.dto.request.collabservice.StartSessionRequest;
import com.example.gateway.dto.response.collabservice.ListSessionResponse;
import com.example.gateway.dto.response.collabservice.SessionResponse;
import com.example.gateway.dto.response.documentservice.DocumentResponse;
import com.example.gateway.dto.response.documentservice.ListDocumentResponse;
import com.example.gateway.service.CollabServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class CollabServiceClientImpl implements CollabServiceClient {
    private static final String USER_SERVICE_URL = "http://localhost:8081";


    private final WebClient webClient;

    public CollabServiceClientImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(USER_SERVICE_URL)
                .build();
    }
    @Override
    public ResponseEntity<SessionResponse> startSession(StartSessionRequest request) {
        var session = webClient
                .post()
                .uri("/api/collaboration/sessions/start")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SessionResponse.class)
                .block();
        return ResponseEntity.ok().body(session);
    }

    @Override
    public ResponseEntity<ListSessionResponse> getActiveSessions(UUID documentId) {
        var session = webClient
                .get()
                .uri("/api/collaboration/sessions/{documentId}", documentId)
                .retrieve()
                .bodyToMono(ListSessionResponse.class)
                .block();
        return ResponseEntity.ok().body(session);
    }

    @Override
    public ResponseEntity<SessionResponse> endSession(UUID sessionId) {
        var session = webClient
                .delete()
                .uri("/api/collaboration/sessions/{sessionId}/end", sessionId)
                .retrieve()
                .bodyToMono(SessionResponse.class)
                .block();
        return ResponseEntity.ok().body(session);
    }
}
