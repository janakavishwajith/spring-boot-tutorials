package io.janaka.springbootstarter.repo;

import io.janaka.springbootstarter.topic.Topic;

import java.util.List;
import java.util.Map;

public interface TopicsRepository {
    void save(Topic topic);
    Map<String, Topic> findAll();
    Topic update(Topic topic);
    void delete(String id);
    Topic findById(String id);

}
