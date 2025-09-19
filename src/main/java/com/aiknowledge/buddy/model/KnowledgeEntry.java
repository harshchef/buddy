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
@Document(collection = "knowledge_entries")
public class KnowledgeEntry {
    @Id
    private String id;
    
    @Field("user_id")
    private String userId;
    
    private String title;
    private String content;
    
    @Field("entry_type")
    private String entryType; // LESSON_LEARNED, BEST_PRACTICE, DESIGN_DECISION, TECHNICAL_DEBT
    
    @Field("source_type")
    private String sourceType; // PULL_REQUEST, COMMIT, JIRA_TICKET, MANUAL
    
    @Field("source_id")
    private String sourceId;
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @Field("updated_at")
    private LocalDateTime updatedAt;
    
    private List<String> tags;
    private String repository;
    
    @Field("confidence_score")
    private Double confidenceScore;
    
    @Field("embedding_vector")
    private List<Double> embeddingVector;
    
    @Field("related_entries")
    private List<String> relatedEntries;
}