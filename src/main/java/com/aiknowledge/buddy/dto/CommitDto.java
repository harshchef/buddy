package com.aiknowledge.buddy.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommitDto {
    private String id;
    private String githubSha;
    private String message;
    private String authorName;
    private String authorEmail;
    private LocalDateTime committedAt;
    private List<String> changedFiles;
    private Integer additions;
    private Integer deletions;
    private String htmlUrl;
}
