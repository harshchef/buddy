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
@Table(name = "summaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pull_request_id")
    private Long pullRequestId;

    @Column(name = "commit_id")
    private Long commitId;

    private String type; // PR_SUMMARY, COMMIT_SUMMARY, KNOWLEDGE_EXTRACTION

    @Column(name = "high_level_summary", columnDefinition = "TEXT")
    private String highLevelSummary;

    @ElementCollection
    @CollectionTable(name = "summary_major_features", joinColumns = @JoinColumn(name = "summary_id"))
    @Column(name = "major_feature")
    private List<String> majorFeatures;

    @ElementCollection
    @CollectionTable(name = "summary_bug_fixes", joinColumns = @JoinColumn(name = "summary_id"))
    @Column(name = "bug_fix")
    private List<String> bugFixes;

    @ElementCollection
    @CollectionTable(name = "summary_design_decisions", joinColumns = @JoinColumn(name = "summary_id"))
    @Column(name = "design_decision")
    private List<String> designDecisions;

    @ElementCollection
    @CollectionTable(name = "summary_lessons_learned", joinColumns = @JoinColumn(name = "summary_id"))
    @Column(name = "lesson_learned")
    private List<String> lessonsLearned;

    @ElementCollection
    @CollectionTable(name = "summary_best_practices", joinColumns = @JoinColumn(name = "summary_id"))
    @Column(name = "best_practice")
    private List<String> bestPractices;

    @ElementCollection
    @CollectionTable(name = "summary_technical_debt", joinColumns = @JoinColumn(name = "summary_id"))
    @Column(name = "technical_debt")
    private List<String> technicalDebt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(name = "summary_embedding_vector", joinColumns = @JoinColumn(name = "summary_id"))
    @Column(name = "vector_value")
    private List<Double> embeddingVector;
}
