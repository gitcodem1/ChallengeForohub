package com.njaimed.forohub.challenge.controller.converter;

import com.njaimed.forohub.challenge.controller.request.TopicRequest;
import com.njaimed.forohub.challenge.model.Topic;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TopicRequestToTopic {

    public Topic convert(TopicRequest topicRequest) {
        return Topic.builder()
                .title(topicRequest.getTitle())
                .message(topicRequest.getMessage())
                .build();
    }
}
