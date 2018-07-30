package com.example.api.topic.service;

import com.example.api.topic.model.Topic;
import com.example.api.topic.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Spring treats it as a singleton, and creates instance of it at booting application
@Service
public class TopicsService {

    @Autowired
    private TopicsRepository topicsRepository;


    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();

        topicsRepository
            .findAll()
            .forEach(topics::add);

        return topics;
    }

    public Topic getTopic(String id) {
        return topicsRepository
                .findById(id)
                .get();
    }

    public void addTopic(Topic topic) {
        topicsRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicsRepository.save(topic);
    }

    public void removeTopic(String id) {
        topicsRepository.deleteById(id);
    }
}
