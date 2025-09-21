package com.aiknowledge.buddy.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentationDto {
    private String id;
    private String repository;
    private String title;
    private String content; // markdown or plain text
    private String docType; // README, API_DOCS, etc.
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> sourcePullRequests;
    private List<String> tags;
    private String version;
}
