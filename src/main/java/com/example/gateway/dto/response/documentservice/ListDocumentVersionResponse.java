package com.example.gateway.dto.response.documentservice;

import java.util.List;

public record ListDocumentVersionResponse(
        List<DocumentVersionResponse> versions
) {
}
