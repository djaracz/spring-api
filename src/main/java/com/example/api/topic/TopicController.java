package com.example.api.topic;

import com.example.api.topic.model.Topic;
import com.example.api.topic.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    // Injects the service instance automatically
    @Autowired
    private TopicsService topicsService;

    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        return topicsService.getTopics();
    }

    // Path variable maps request id as an argument in this case
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicsService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addTopic(@RequestBody Topic topic) {
        topicsService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTopic(@RequestBody Topic topic) {
        topicsService.updateTopic(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeTopic(@PathVariable String id) {
        topicsService.removeTopic(id);
    }
}
