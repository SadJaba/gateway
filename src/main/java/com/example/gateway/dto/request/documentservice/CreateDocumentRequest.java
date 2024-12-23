package com.example.gateway.dto.request.documentservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateDocumentRequest(
        String title,
        String content,
        @JsonProperty("onwer_id") String ownerId,
        @JsonProperty("is_public") boolean isPublic
){
}
