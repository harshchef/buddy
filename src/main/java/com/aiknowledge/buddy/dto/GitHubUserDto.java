package com.aiknowledge.buddy.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GitHubUserDto {
    private String githubId;
    private String githubUsername;
    private String email;
    private String name;
    private String avatarUrl;
}
