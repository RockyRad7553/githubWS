package com.radtools.springboottraining.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Topic1", "FirstTopic"),
			new Topic("2", "Topic2", "SecondTopic"), new Topic("3", "Topic3", "ThirdTopic")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(String id,Topic topic) {
		for(int i=0;i<topics.size();i++){
			if(topics.get(i).getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void removeTopic(String id) {
		topics.removeIf(t->t.getId().equals(id));
		//topics.remove(getTopic(id));
	}
	
	
}
