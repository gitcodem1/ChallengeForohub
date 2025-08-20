package com.njaimed.forohub.challenge.controller.converter;

import com.njaimed.forohub.challenge.controller.response.TopicResponse;
import com.njaimed.forohub.challenge.model.Topic;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TopicModelToResponse {
    public TopicResponse convert(Topic topic) {
        return TopicResponse
                .builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .message(topic.getMessage())
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .build();
    }
}
