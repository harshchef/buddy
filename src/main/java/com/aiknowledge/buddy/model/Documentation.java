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
@Document(collection = "documentation")
public class Documentation {
    @Id
    private String id;
    
    @Field("user_id")
    private String userId;
    
    private String repository;
    private String title;
    private String content;
    
    @Field("doc_type")
    private String docType; // README, API_DOCS, ARCHITECTURE, CHANGELOG
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @Field("updated_at")
    private LocalDateTime updatedAt;
    
    @Field("source_pull_requests")
    private List<String> sourcePullRequests;
    
    @Field("embedding_vector")
    private List<Double> embeddingVector;
    
    private List<String> tags;
    private String version;

}