package com.aiknowledge.buddy.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiknowledge.buddy.model.User;
import com.aiknowledge.buddy.repository.UserRepository;
import com.aiknowledge.buddy.utility.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider; // service to generate/validate JWT

    // Endpoint to get user info using JWT
    @GetMapping("/me")
    public ResponseEntity<?> getUserInfo(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7); // Remove "Bearer "
        Long githubId;

        try {
            githubId = jwtTokenProvider.getUserIdFromToken(token); // extract user ID from JWT
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
        }

        Optional<User> optionalUser = userRepository.findByGithubId(githubId);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found in DB");
        }
    }
}
