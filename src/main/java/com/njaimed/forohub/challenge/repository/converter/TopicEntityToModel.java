package com.njaimed.forohub.challenge.repository.converter;

import com.njaimed.forohub.challenge.model.Topic;
import com.njaimed.forohub.challenge.repository.entity.TopicEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TopicEntityToModel {

    public Topic convert(TopicEntity topicEntity) {
        return Topic
                .builder()
                .id(topicEntity.getId())
                .title(topicEntity.getTitle())
                .message(topicEntity.getMessage())
                .createdAt(topicEntity.getCreatedAt())
                .updatedAt(topicEntity.getUpdatedAt())
                .build();
    }
}
