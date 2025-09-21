package com.aiknowledge.buddy.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QARequestDto {
    private String question;
    private String context; // optional - can be repo, PR, or general
    private String userId;
}
