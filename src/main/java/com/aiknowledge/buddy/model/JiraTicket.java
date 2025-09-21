package com.aiknowledge.buddy.model;




import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "jira_tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JiraTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jira_key")
    private String jiraKey;

    @Column(name = "user_id")
    private Long userId;

    private String summary;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String status;

    @Column(name = "issue_type")
    private String issueType;

    private String priority;

    @Column(name = "assignee_name")
    private String assigneeName;

    @Column(name = "reporter_name")
    private String reporterName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    @Column(name = "jira_url")
    private String jiraUrl;

    @ElementCollection
    @CollectionTable(name = "jira_ticket_labels", joinColumns = @JoinColumn(name = "jira_ticket_id"))
    @Column(name = "label")
    private List<String> labels;

    @ElementCollection
    @CollectionTable(name = "jira_ticket_components", joinColumns = @JoinColumn(name = "jira_ticket_id"))
    @Column(name = "component")
    private List<String> components;

    @Column(name = "story_points")
    private Integer storyPoints;

    @ElementCollection
    @CollectionTable(name = "jira_ticket_linked_pull_requests", joinColumns = @JoinColumn(name = "jira_ticket_id"))
    @Column(name = "linked_pull_request")
    private List<String> linkedPullRequests;
}
