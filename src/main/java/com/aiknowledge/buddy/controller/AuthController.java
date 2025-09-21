package com.aiknowledge.buddy.controller;

import com.aiknowledge.buddy.model.User;
import com.aiknowledge.buddy.repository.UserRepository;
import com.aiknowledge.buddy.service.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

@GetMapping("/success")
public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
    if (principal == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not authenticated");
    }

    String githubId = String.valueOf(principal.getAttribute("id"));

    return userRepository.findByGithubId(githubId)
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found in DB"));
}

}
