package com.aiknowledge.buddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Entity
@Table(name = "pull_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PullRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "github_id")
    private Long githubId;

    @Column(name = "user_id")
    private Long userId;

    private String repository;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String state;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "merged_at")
    private LocalDateTime mergedAt;

    @Column(name = "author_username")
    private String authorUsername;

    @Column(name = "base_branch")
    private String baseBranch;

    @Column(name = "head_branch")
    private String headBranch;

    @ElementCollection
    @CollectionTable(name = "pull_request_changed_files", joinColumns = @JoinColumn(name = "pull_request_id"))
    @Column(name = "changed_file")
    private List<String> changedFiles;

    private Integer additions;
    private Integer deletions;

    @Column(name = "commits_count")
    private Integer commitsCount;

    @Column(columnDefinition = "TEXT")
    private String diff;

    @ElementCollection
    @CollectionTable(name = "pull_request_review_comments", joinColumns = @JoinColumn(name = "pull_request_id"))
    @Column(name = "review_comment")
    private List<String> reviewComments; // Simplified map -> string

    @Column(name = "html_url")
    private String htmlUrl;

    @ElementCollection
    @CollectionTable(name = "pull_request_labels", joinColumns = @JoinColumn(name = "pull_request_id"))
    @Column(name = "label")
    private List<String> labels;
}
