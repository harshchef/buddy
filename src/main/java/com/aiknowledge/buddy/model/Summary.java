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
@Document(collection = "summaries")
public class Summary {
    @Id
    private String id;
    
    @Field("user_id")
    private String userId;
    
    @Field("pull_request_id")
    private String pullRequestId;
    
    @Field("commit_id")
    private String commitId;
    
    private String type; // PR_SUMMARY, COMMIT_SUMMARY, KNOWLEDGE_EXTRACTION
    
    @Field("high_level_summary")
    private String highLevelSummary;
    
    @Field("major_features")
    private List<String> majorFeatures;
    
    @Field("bug_fixes")
    private List<String> bugFixes;
    
    @Field("design_decisions")
    private List<String> designDecisions;
    
    @Field("lessons_learned")
    private List<String> lessonsLearned;
    
    @Field("best_practices")
    private List<String> bestPractices;
    
    @Field("technical_debt")
    private List<String> technicalDebt;
    
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @Field("embedding_vector")
    private List<Double> embeddingVector;
}