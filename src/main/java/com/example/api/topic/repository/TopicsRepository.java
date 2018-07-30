package com.example.api.topic.repository;

import com.example.api.topic.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicsRepository extends CrudRepository<Topic, String> { }
