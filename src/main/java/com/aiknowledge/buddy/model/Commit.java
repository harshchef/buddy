
package com.aiknowledge.buddy.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "commits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "github_sha")
    private String githubSha;

    @Column(name = "user_id")
    private Long userId;

    private String repository;
    private String message;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_email")
    private String authorEmail;

    @Column(name = "committed_at")
    private LocalDateTime committedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(name = "commit_changed_files", joinColumns = @JoinColumn(name = "commit_id"))
    @Column(name = "changed_file")
    private List<String> changedFiles;

    private Integer additions;
    private Integer deletions;

    @Column(name = "html_url")
    private String htmlUrl;

    @Column(name = "pull_request_id")
    private String pullRequestId;
}
