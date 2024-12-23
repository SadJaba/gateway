//package com.example.gateway;
//import com.example.gateway.controller.collabservice.CollabController;
//import com.example.gateway.controller.userservice.AuthController;
//import com.example.gateway.dto.request.userservice.AuthenticationRequest;
//import com.example.gateway.dto.response.collabservice.ListSessionResponse;
//import com.example.gateway.dto.response.userservice.UserResponse;
//import com.example.gateway.service.CollabServiceClient;
//import com.example.gateway.service.UserServiceClient;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.UUID;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//class GatewayApiTests {
//
//    @Autowired
//    private CollabController collabController;
//
//    @Autowired
//    private AuthController authController;
//    @Autowired
//    private CollabServiceClient collabServiceClient;
//    @Autowired
//    private UserServiceClient userServiceClient;
//
//    @Test
//    void testAuthenticateWithValidCredentials() throws Exception {
//        Mockito.when(userServiceClient.authenticate(any(AuthenticationRequest.class)))
//                .thenReturn(ResponseEntity.ok(UserResponse.builder().build()));
//
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
//
//        mockMvc.perform(post("/auth/signin")
//                        .contentType("application/json")
//                        .content("{\"email\":\"test@example.com\",\"password\":\"password\"}"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testAuthenticateWithInvalidCredentials() throws Exception {
//        Mockito.when(userServiceClient.authenticate(any(AuthenticationRequest.class)))
//                .thenThrow(new RuntimeException("Invalid credentials"));
//
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
//
//        mockMvc.perform(post("/auth/signin")
//                        .contentType("application/json")
//                        .content("{\"email\":\"wrong@example.com\",\"password\":\"wrongpassword\"}"))
//                .andExpect(status().is5xxServerError());
//    }
//
//    @Test
//    void testUnauthorizedAccessToProtectedEndpoint() throws Exception {
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(collabController).build();
//
//        mockMvc.perform(get("/documents/all"))
//                .andExpect(status().isForbidden());
//    }
//
//    @Test
//    void testAccessToPublicEndpoint() throws Exception {
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
//
//        mockMvc.perform(get("/auth/signup"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void testGetActiveSessions() throws Exception {
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(collabController).build();
//
//        mockMvc.perform(get("/session/all/{id}", UUID.randomUUID()))
//                .andExpect(status().isOk());
//    }
//}
//
