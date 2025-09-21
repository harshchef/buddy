package com.aiknowledge.buddy.service;

import com.aiknowledge.buddy.model.User;
import com.aiknowledge.buddy.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public User processOAuthPostLogin(OAuth2User oAuth2User, String accessToken) {
        String githubId = String.valueOf(oAuth2User.getAttribute("id"));
        String githubUsername = oAuth2User.getAttribute("login");
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String avatarUrl = oAuth2User.getAttribute("avatar_url");

        User user = userRepository.findByGithubId(githubId).orElseGet(User::new);

        user.setGithubId(githubId);
        user.setGithubUsername(githubUsername);
        user.setEmail(email);
        user.setName(name);
        user.setAvatarUrl(avatarUrl);
        user.setAccessToken(accessToken);
        user.setUpdatedAt(LocalDateTime.now());

        if (user.getId() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }

        return userRepository.save(user);
    }
}
