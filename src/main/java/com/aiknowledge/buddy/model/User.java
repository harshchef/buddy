package com.aiknowledge.buddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    
    @Field("github_id")
    private String githubId;
    
    @Field("github_username")
    private String githubUsername;
    
    private String email;
    private String name;
    
    @Field("avatar_url")
    private String avatarUrl;
    
    @Field("access_token")
    private String accessToken;
    
    @Field("refresh_token")
    private String refreshToken;
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @Field("updated_at")
    private LocalDateTime updatedAt;
    
    private List<String> repositories;
}
