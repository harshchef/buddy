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
@Document(collection = "jira_tickets")
public class JiraTicket {
    @Id
    private String id;
    
    @Field("jira_key")
    private String jiraKey;
    
    @Field("user_id")
    private String userId;
    
    private String summary;
    private String description;
    private String status;
    
    @Field("issue_type")
    private String issueType;
    
    private String priority;
    
    @Field("assignee_name")
    private String assigneeName;
    
    @Field("reporter_name")
    private String reporterName;
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @Field("updated_at")
    private LocalDateTime updatedAt;
    
    @Field("resolved_at")
    private LocalDateTime resolvedAt;
    
    @Field("jira_url")
    private String jiraUrl;
    
    private List<String> labels;
    private List<String> components;
    
    @Field("story_points")
    private Integer storyPoints;
    
    @Field("linked_pull_requests")
    private List<String> linkedPullRequests;
}