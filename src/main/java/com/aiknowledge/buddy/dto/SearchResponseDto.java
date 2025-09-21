package com.aiknowledge.buddy.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchResponseDto<T> {
    private List<T> results;
    private Long totalCount;
}
