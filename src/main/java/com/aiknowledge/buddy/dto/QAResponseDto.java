package com.aiknowledge.buddy.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QAResponseDto {
    private String answer;
    private Double confidenceScore;
    private String source; // KNOWLEDGE_BASE, CLAUDE, DOCS
}
