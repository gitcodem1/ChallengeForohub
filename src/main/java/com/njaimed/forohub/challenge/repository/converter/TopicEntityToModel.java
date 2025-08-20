package com.njaimed.forohub.challenge.repository.converter;

import com.njaimed.forohub.challenge.controller.response.PaginatedResponse;
import com.njaimed.forohub.challenge.model.Topic;
import com.njaimed.forohub.challenge.repository.entity.TopicEntity;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public PaginatedResponse convertWithPage(Page<TopicEntity> topicPage) {
        List<Topic> content = topicPage.getContent()
                .stream()
                .map(TopicEntityToModel::convert)
                .collect(Collectors.toList());

        return new PaginatedResponse(
                content,
                topicPage.getNumber(),
                topicPage.getTotalPages(),
                topicPage.getTotalElements(),
                topicPage.getSize()
        );

    }
}
