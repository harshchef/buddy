package com.aiknowledge.buddy.config;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import com.aiknowledge.buddy.service.CustomOAuth2UserService;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login**", "/error", "/api/auth/success").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2
                .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
                .successHandler((request, response, authentication) -> {
                    // Generate JWT after successful OAuth login
                    OAuth2User oauthUser = (OAuth2User) authentication.getPrincipal();
                    Long githubId = Long.valueOf(oauthUser.getAttribute("id").toString());

                    String token = customOAuth2UserService.generateJwtForUser(githubId);

                    // Return JWT to client (JSON)
                    response.setContentType("application/json");
                    response.getWriter().write("{\"token\":\"" + token + "\"}");
                })
            )
            .logout(logout -> logout.logoutSuccessUrl("/").permitAll());

        return http.build();
    }

    // JwtDecoder (optional for ResourceServer JWT validation)
    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        return NimbusJwtDecoder.withSecretKey(key).build();
    }
}
