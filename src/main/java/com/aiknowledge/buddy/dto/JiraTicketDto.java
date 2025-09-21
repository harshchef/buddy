package com.aiknowledge.buddy.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JiraTicketDto {
    private String id;
    private String jiraKey;
    private String summary;
    private String status;
    private String assigneeName;
    private String reporterName;
    private String priority;
    private String jiraUrl;
}
