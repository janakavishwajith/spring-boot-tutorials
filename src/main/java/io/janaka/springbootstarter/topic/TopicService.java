package io.janaka.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	private List<Topic> allTopics = new ArrayList(Arrays.asList(
			new Topic("1", "Spring", "Spring desc"),
			new Topic("2", "Next", "Lesson on Spring")
			
			));
	
	public List<Topic> getAllTopics() {
		return allTopics;
	}
	
	public void addTopic(Topic topic) {
		allTopics.add(topic);
	}

}
