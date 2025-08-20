package com.njaimed.forohub.challenge.service;

import com.njaimed.forohub.challenge.model.Topic;
import com.njaimed.forohub.challenge.repository.TopicRepository;
import com.njaimed.forohub.challenge.repository.converter.TopicEntityToModel;
import com.njaimed.forohub.challenge.repository.converter.TopicModelToEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public Topic updateTopic(Topic newTopic, Integer topicId) {
        return topicRepository.findById(topicId)
                .map(topic -> {
                    topic.setTitle(newTopic.getTitle());
                    topic.setMessage(newTopic.getMessage());
                    topic.setUpdatedAt(LocalDateTime.now());
                    return topic;
                })
                .map(topicRepository::save)
                .map(TopicEntityToModel::convert)
                .orElseThrow(() -> new RuntimeException("*Topico no encontrado*"));

    }

    @Override
    public void deleteTopic(Integer topicId) {
        topicRepository.deleteById(topicId);
    }
}
