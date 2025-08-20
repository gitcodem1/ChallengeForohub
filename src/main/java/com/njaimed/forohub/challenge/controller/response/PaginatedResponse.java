package com.njaimed.forohub.challenge.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.njaimed.forohub.challenge.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
@AllArgsConstructor
public class PaginatedResponse {
    List<Topic> content;
    int pageNumber;
    int totalPages;
    long totalElements;
    int pageSize;
}
