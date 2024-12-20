package com.example.gateway.controller.documentservice;

import com.example.gateway.dto.request.documentservice.CreateDocumentRequest;
import com.example.gateway.dto.request.documentservice.UpdateDocumentRequest;
import com.example.gateway.dto.response.documentservice.DocumentResponse;
import com.example.gateway.dto.response.documentservice.ListDocumentResponse;
import com.example.gateway.dto.response.documentservice.ListDocumentVersionResponse;
import com.example.gateway.service.DocumentServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
@CrossOrigin
public class DocumentController {
    private final DocumentServiceClient documentServiceClient;

    @PreAuthorize("hasAnyRole('USER')")
    @RequestMapping
    public ResponseEntity<ListDocumentResponse> getAllDocuments() {
        return documentServiceClient.getAllDocuments();
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/get/{id}")
    public ResponseEntity<DocumentResponse> getDocumentById(@PathVariable("id") UUID id) {
        return documentServiceClient.getDocument(id);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/history/{id}")
    public ResponseEntity<ListDocumentVersionResponse> getDocumentHistory(@PathVariable("id") UUID id) {
        return documentServiceClient.getDocumentHistory(id);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DocumentResponse> deleteDocument(@PathVariable("id") UUID id) {
        return documentServiceClient.deleteDocument(id);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/create")
    public ResponseEntity<DocumentResponse> createDocument(@RequestBody CreateDocumentRequest request) {
        return documentServiceClient.createDocument(request);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<DocumentResponse> updateDocument(@PathVariable("id") UUID id, @RequestBody UpdateDocumentRequest request) {
        return documentServiceClient.updateDocument(id, request);
    }
}
