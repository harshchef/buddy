package com.aiknowledge.buddy.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.aiknowledge.buddy.model.User;
import com.aiknowledge.buddy.utility.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String accessToken = userRequest.getAccessToken().getTokenValue();

        // Save GitHub user + token into DB
        User user = authService.processOAuthPostLogin(oAuth2User, accessToken);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                oAuth2User.getAttributes(),
                "login"
        );
    }

    // Generate JWT for given userId
    public String generateJwtForUser(Long githubId) {
        return jwtTokenProvider.generateToken(githubId);
    }
}
