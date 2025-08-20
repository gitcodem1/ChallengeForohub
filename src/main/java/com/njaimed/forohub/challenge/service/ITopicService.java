package com.njaimed.forohub.challenge.service;

import com.njaimed.forohub.challenge.model.Topic;

import java.util.List;

public interface ITopicService {
    List<Topic> getTopics();

    Topic createTopic(Topic topic);

}
