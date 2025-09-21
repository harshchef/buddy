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
@Table(name = "documentation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Documentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String repository;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "doc_type")
    private String docType; // README, API_DOCS, ARCHITECTURE, CHANGELOG

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ElementCollection
    @CollectionTable(name = "documentation_source_pull_requests", joinColumns = @JoinColumn(name = "documentation_id"))
    @Column(name = "source_pull_request")
    private List<String> sourcePullRequests;

    @ElementCollection
    @CollectionTable(name = "documentation_embedding_vector", joinColumns = @JoinColumn(name = "documentation_id"))
    @Column(name = "vector_value")
    private List<Double> embeddingVector;

    @ElementCollection
    @CollectionTable(name = "documentation_tags", joinColumns = @JoinColumn(name = "documentation_id"))
    @Column(name = "tag")
    private List<String> tags;

    private String version;
}
