package com.sumerge.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;
    private final List<Topic> topics=new ArrayList<Topic>( Arrays.asList(
            new Topic("spring", "spring framework","spring fw desc"),
            new Topic("js", "javascript","js coding language desc"),
            new Topic("java", "java lang","java coding language")
    ));
    public List<Topic> getAllTopics(){
        List<Topic> topicsList= new ArrayList<Topic>();
        topicRepository.findAll().forEach(topicsList::add);
        return topicsList;
    }
    public Topic getTopic(String topicID){
       return topics.stream().filter(t-> t.getID().equals(topicID)).findFirst().get();
    }
    public void addTopic(Topic topic){
        topics.add(topic);
    }
    public void editTopic(String topicId, Topic topic){
        for(int i=0; i<topics.size(); i++){
            if(topics.get(i).equals(topic)){
                topics.set(i, topic);
                return;
            }
        }
    }
    public void deleteTopic(String topicId){
        for(int i=0; i<topics.size(); i++){
            if(topics.get(i).getID().equals(topicId)){
                topics.remove(i);
                return;
            }
        }
    }
}
