package com.example.api.topic.service;

import com.example.api.topic.model.Topic;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Spring treats it as a singleton, and creates instance of it at booting application
@Service
public class TopicsService {

    private List<Topic> topics = new ArrayList<>(
        Arrays.asList(
            new Topic("1", "name", "desc"),
            new Topic("2", "name2", "desc2"),
            new Topic("3", "name3", "desc3")
        )
    );


    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics
                .stream()
                .filter(topic -> topic
                        .getId()
                        .equals(id)
                )
                .findFirst()
                .get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}