package com.njaimed.forohub.challenge.service;

import com.njaimed.forohub.challenge.controller.response.PaginatedResponse;
import com.njaimed.forohub.challenge.model.Topic;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITopicService {
    PaginatedResponse getTopics(Pageable pageable);

    Topic createTopic(Topic topic);

    Topic updateTopic(Topic topic, Integer topicId);

    void deleteTopic(Integer topicId);

}
