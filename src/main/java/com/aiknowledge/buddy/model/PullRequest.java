package com.aiknowledge.buddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pull_requests")
public class PullRequest {
    @Id
    private String id;
        
    @Field("github_id")
    private Long githubId;
        
    @Field("user_id")
    private String userId;
        
    private String repository;
    private String title;
    private String description;
    private String state;
        
    @Field("created_at")
    private LocalDateTime createdAt;
        
    @Field("updated_at")
    private LocalDateTime updatedAt;
        
    @Field("merged_at")
    private LocalDateTime mergedAt;
        
    @Field("author_username")
    private String authorUsername;
        
    @Field("base_branch")
    private String baseBranch;
        
    @Field("head_branch")
    private String headBranch;
        
    @Field("changed_files")
    private List<String> changedFiles;
        
    @Field("additions")
    private Integer additions;
        
    @Field("deletions")
    private Integer deletions;
        
    @Field("commits_count")
    private Integer commitsCount;
        
    private String diff;
        
    @Field("review_comments")
    private List<Map<String, Object>> reviewComments;
        
    @Field("html_url")
    private String htmlUrl;
        
    private List<String> labels;
}
