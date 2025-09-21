package com.aiknowledge.buddy.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KnowledgeEntryDto {
    private String id;
    private String title;
    private String content;
    private String entryType;   // LESSON_LEARNED, BEST_PRACTICE, etc.
    private String sourceType;  // PULL_REQUEST, COMMIT, etc.
    private String sourceId;
    private LocalDateTime createdAt;
    private List<String> tags;
    private String repository;
    private Double confidenceScore;
}
