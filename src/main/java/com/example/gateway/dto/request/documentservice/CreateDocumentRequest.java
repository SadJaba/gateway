package com.example.gateway.dto.request.documentservice;

public record CreateDocumentRequest(
        String title,
        String content,
        String ownerId,
        boolean isPublic
){
}
