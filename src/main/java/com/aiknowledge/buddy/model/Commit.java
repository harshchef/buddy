
package com.aiknowledge.buddy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "commits")
public class Commit {
    @Id
    private String id;
    
    @Field("github_sha")
    private String githubSha;
    
    @Field("user_id")
    private String userId;
    
    private String repository;
    private String message;
    
    @Field("author_name")
    private String authorName;
    
    @Field("author_email")
    private String authorEmail;
    
    @Field("committed_at")
    private LocalDateTime committedAt;
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @Field("changed_files")
    private List<String> changedFiles;
    
    private Integer additions;
    private Integer deletions;
    
    @Field("html_url")
    private String htmlUrl;
    
    @Field("pull_request_id")
    private String pullRequestId;
}