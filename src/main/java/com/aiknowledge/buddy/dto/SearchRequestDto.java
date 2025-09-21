package com.aiknowledge.buddy.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchRequestDto {
    private String keyword;
    private String userId;
    private String repository;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String type; // PR, COMMIT, KNOWLEDGE_ENTRY
}
