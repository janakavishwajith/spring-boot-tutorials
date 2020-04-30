package io.janaka.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import io.janaka.springbootstarter.repo.TopicsRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
//	private List<Topic> allTopics = new ArrayList(Arrays.asList(
//			new Topic("1", "Spring", "Spring desc"),
//			new Topic("2", "Next", "Lesson on Spring")
//
//			));

	private TopicsRepository topicsRepository;

	public TopicService(TopicsRepository topicsRepository) {
		this.topicsRepository = topicsRepository;
	}


	public List<Topic> getAllTopics() {
		return new ArrayList<>(topicsRepository.findAll().values());
	}
	
	public void addTopic(Topic topic) {
		topicsRepository.save(topic);
	}

	public Topic getTopicById(String id) {
		return topicsRepository.findById(id);
	}

	public void deleteTopic(String id) {
		topicsRepository.delete(id);
	}

	public Topic updateTopic(Topic topic) {
		return topicsRepository.update(topic);
	}

}
