package io.janaka.springbootstarter.repo;

import io.janaka.springbootstarter.topic.Topic;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TopicsRepositoryImpl implements TopicsRepository {

    private RedisTemplate<String, Topic> topicTemplate;
    private HashOperations hashOperations;

    public TopicsRepositoryImpl(RedisTemplate<String, Topic> topicTemplate) {
        this.topicTemplate = topicTemplate;

        hashOperations = topicTemplate.opsForHash();
    }

    @Override
    public void save(Topic topic) {
        hashOperations.put("TOPIC", topic.getId(), topic);
    }

    @Override
    public Map<String, Topic> findAll() {
        return hashOperations.entries("TOPIC");
    }

    @Override
    public Topic update(Topic topic) {
        save(topic);
        return findById(topic.getId());
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("TOPIC", id);
    }

    @Override
    public Topic findById(String id) {

        return (Topic) hashOperations.get("TOPIC", id);
    }
}
