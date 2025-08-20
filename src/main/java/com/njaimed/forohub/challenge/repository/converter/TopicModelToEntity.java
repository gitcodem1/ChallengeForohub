package com.njaimed.forohub.challenge.repository.converter;

import com.njaimed.forohub.challenge.model.Topic;
import com.njaimed.forohub.challenge.repository.entity.TopicEntity;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class TopicModelToEntity {
    public TopicEntity convert(Topic topic) {
        return TopicEntity
                .builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .message(topic.getMessage())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
