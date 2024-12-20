package com.example.gateway.service;

import com.example.gateway.dto.request.documentservice.CreateDocumentRequest;
import com.example.gateway.dto.request.documentservice.UpdateDocumentRequest;
import com.example.gateway.dto.response.documentservice.DocumentResponse;
import com.example.gateway.dto.response.documentservice.DocumentVersionResponse;
import com.example.gateway.dto.response.documentservice.ListDocumentResponse;
import com.example.gateway.dto.response.documentservice.ListDocumentVersionResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface DocumentServiceClient {
    ResponseEntity<DocumentResponse> getDocument(UUID documentId);
    ResponseEntity<DocumentResponse> createDocument(CreateDocumentRequest request);
    ResponseEntity<DocumentResponse> updateDocument(UUID documentId, UpdateDocumentRequest request);
    ResponseEntity<ListDocumentResponse> getAllDocuments();
    ResponseEntity<DocumentResponse> deleteDocument(UUID documentId);
    ResponseEntity<ListDocumentVersionResponse> getDocumentHistory(UUID documentId);
}
