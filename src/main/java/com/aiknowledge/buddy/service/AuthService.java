package com.aiknowledge.buddy.service;

import java.time.LocalDateTime;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.aiknowledge.buddy.model.User;
import com.aiknowledge.buddy.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
//
//    public User processOAuthPostLogin(OAuth2User oAuth2User, String accessToken) {
//        String githubId = String.valueOf(oAuth2User.getAttribute("id"));
//        String githubUsername = oAuth2User.getAttribute("login");
//        String email = oAuth2User.getAttribute("email");
//        String name = oAuth2User.getAttribute("name");
//        String avatarUrl = oAuth2User.getAttribute("avatar_url");
//
//        User user = userRepository.findByGithubId(githubId).orElseGet(User::new);
//
//        user.setGithubId(githubId);
//        user.setGithubUsername(githubUsername);
//        user.setEmail(email);
//        user.setName(name);
//        user.setAvatarUrl(avatarUrl);
//        user.setAccessToken(accessToken);
//        user.setUpdatedAt(LocalDateTime.now());
//
//        if (user.getId() == null) {
//            user.setCreatedAt(LocalDateTime.now());
//        }
//
//        return userRepository.save(user);
//    }

    public User processOAuthPostLogin(OAuth2User oAuth2User, String accessToken) {
        Object idAttr = oAuth2User.getAttribute("id");
        System.out.println("Harsh OAuth2 attributes: " + oAuth2User.getAttributes());
  String githubIdStr = idAttr != null ? String.valueOf(idAttr) : null;
Long githubId = githubIdStr != null ? Long.valueOf(githubIdStr) : null;

        String githubUsername = (String) oAuth2User.getAttribute("login");
        String email = (String) oAuth2User.getAttribute("email");
        String name = (String) oAuth2User.getAttribute("name");
        String avatarUrl = (String) oAuth2User.getAttribute("avatar_url");

        User user = userRepository.findByGithubId(githubId).orElseGet(User::new);
    Long githubId1 = Long.valueOf(oAuth2User.getAttribute("id").toString());
        user.setGithubId(githubId1);

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
