package com.njaimed.forohub.challenge.service;

import com.njaimed.forohub.challenge.model.Topic;
import com.njaimed.forohub.challenge.repository.TopicRepository;
import com.njaimed.forohub.challenge.repository.converter.TopicEntityToModel;
import com.njaimed.forohub.challenge.repository.converter.TopicModelToEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TopicService implements ITopicService {

    private final TopicRepository topicRepository;

    @Override
    public List<Topic> getTopics() {
        return topicRepository.findAll().stream()
                .map(TopicEntityToModel::convert)
                .collect(Collectors.toList());
    }

  @Override
  public Topic createTopic(Topic topic) {
    return TopicEntityToModel.convert(
            topicRepository.save(TopicModelToEntity.convert(topic)));

  }
}
