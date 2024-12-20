package com.example.gateway.dto.response.userservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Data
public class UserDetailsResponse {

    private UUID id;
    private String username;
    private List<Authority> authorities;

    // Inner class for Authority
    @Getter
    @Setter
    @Data
    public static class Authority {
        @JsonProperty("authority")
        private String authority;
    }
}
