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
@Table(name = "knowledge_entries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KnowledgeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "entry_type")
    private String entryType; // LESSON_LEARNED, BEST_PRACTICE, DESIGN_DECISION, TECHNICAL_DEBT

    @Column(name = "source_type")
    private String sourceType; // PULL_REQUEST, COMMIT, JIRA_TICKET, MANUAL

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ElementCollection
    @CollectionTable(name = "knowledge_entry_tags", joinColumns = @JoinColumn(name = "knowledge_entry_id"))
    @Column(name = "tag")
    private List<String> tags;

    private String repository;

    @Column(name = "confidence_score")
    private Double confidenceScore;

    @ElementCollection
    @CollectionTable(name = "knowledge_entry_embedding_vector", joinColumns = @JoinColumn(name = "knowledge_entry_id"))
    @Column(name = "vector_value")
    private List<Double> embeddingVector;

    @ElementCollection
    @CollectionTable(name = "knowledge_entry_related_entries", joinColumns = @JoinColumn(name = "knowledge_entry_id"))
    @Column(name = "related_entry")
    private List<String> relatedEntries;
}
