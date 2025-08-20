package com.njaimed.forohub.challenge.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode
public class TopicResponse {
    Integer id;
    String title;
    String message;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
