package com.njaimed.forohub.challenge.controller;

import com.njaimed.forohub.challenge.controller.converter.TopicModelToResponse;
import com.njaimed.forohub.challenge.controller.converter.TopicRequestToTopic;
import com.njaimed.forohub.challenge.controller.request.TopicRequest;
import com.njaimed.forohub.challenge.controller.response.TopicResponse;
import com.njaimed.forohub.challenge.service.ITopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topic")
public class TopicController {

    private final ITopicService topicService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TopicResponse> getTopics() {
        return topicService.getTopics().stream()
                .map(TopicModelToResponse::convert)
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TopicResponse createTopic(@Valid @RequestBody TopicRequest topicRequest) {
        return TopicModelToResponse.convert(topicService.createTopic(TopicRequestToTopic.convert(topicRequest)));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{topicId}")
    public TopicResponse updateTopic(@Valid @RequestBody TopicRequest topicRequest, @PathVariable Integer topicId) {
        return TopicModelToResponse.convert(topicService.updateTopic(TopicRequestToTopic.convert(topicRequest), topicId));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{topicId}")
    public void deleteTopic(@PathVariable Integer topicId) {
        topicService.deleteTopic(topicId);
    }
}
