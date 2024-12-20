package com.example.gateway.service.impl;

import com.example.gateway.dto.request.documentservice.CreateDocumentRequest;
import com.example.gateway.dto.request.documentservice.UpdateDocumentRequest;
import com.example.gateway.dto.response.documentservice.DocumentResponse;
import com.example.gateway.dto.response.documentservice.DocumentVersionResponse;
import com.example.gateway.dto.response.documentservice.ListDocumentResponse;
import com.example.gateway.dto.response.documentservice.ListDocumentVersionResponse;
import com.example.gateway.dto.response.userservice.UserResponse;
import com.example.gateway.service.DocumentServiceClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceClientImpl implements DocumentServiceClient {
    private static final String USER_SERVICE_URL = "http://localhost:8080";

    private final WebClient webClient;

    public DocumentServiceClientImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(USER_SERVICE_URL)
                .build();
    }


    @Override
    public ResponseEntity<DocumentResponse> getDocument(UUID documentId) {
        var doc = webClient
                .get()
                .uri("/api/documents/{documentId}", documentId)
                .retrieve()
                .bodyToMono(DocumentResponse.class)
                .block();
        return ResponseEntity.ok(doc);
    }

    @Override
    public ResponseEntity<DocumentResponse> createDocument(CreateDocumentRequest request) {
        var doc = webClient
                .post()
                .uri("/api/documents/new")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(DocumentResponse.class)
                .block();
        return ResponseEntity.ok().body(doc);
    }

    @Override
    public ResponseEntity<DocumentResponse> updateDocument(UUID documentId, UpdateDocumentRequest request) {
        var doc = webClient
                .post()
                .uri("/api/documents/{documentId}/update", documentId)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(DocumentResponse.class)
                .block();
        return ResponseEntity.ok().body(doc);
    }

    @Override
    public ResponseEntity<ListDocumentResponse> getAllDocuments() {
        var doc = webClient
                .get()
                .uri("/api/documents/all")
                .retrieve()
                .bodyToMono(ListDocumentResponse.class)
                .block();
        return ResponseEntity.ok().body(doc);
    }

    @Override
    public ResponseEntity<DocumentResponse> deleteDocument(UUID documentId) {
        var doc = webClient
                .delete()
                .uri("/api/documents/{id}/delete", documentId)
                .retrieve()
                .bodyToMono(DocumentResponse.class)
                .block();
        return ResponseEntity.ok().body(doc);
    }

    @Override
    public ResponseEntity<ListDocumentVersionResponse> getDocumentHistory(UUID documentId) {
        var doc = webClient
                .get()
                .uri("/api/documents/{id}/history", documentId)
                .retrieve()
                .bodyToMono(ListDocumentVersionResponse.class)
                .block();
        return ResponseEntity.ok().body(doc);
    }
}
