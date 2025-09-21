package com.aiknowledge.buddy.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PullRequestDto {
    private String id;
    private Long githubId;
    private String title;
    private String description;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime mergedAt;
    private String authorUsername;
    private String baseBranch;
    private String headBranch;
    private List<String> changedFiles;
    private Integer additions;
    private Integer deletions;
    private Integer commitsCount;
    private String htmlUrl;
    private List<String> labels;
}
