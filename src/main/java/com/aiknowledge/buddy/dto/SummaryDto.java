package com.aiknowledge.buddy.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryDto {
    private String id;
    private String type; // PR_SUMMARY, COMMIT_SUMMARY
    private String highLevelSummary;
    private List<String> majorFeatures;
    private List<String> bugFixes;
    private List<String> designDecisions;
    private List<String> lessonsLearned;
    private List<String> bestPractices;
    private List<String> technicalDebt;
    private LocalDateTime createdAt;
}
