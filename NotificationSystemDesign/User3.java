package NotificationSystemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User3 implements Observer{
    public String name;
    public Map<String,List<Notification>>topicNotificationMap;

    public User3(String name){
        this.name=name;
        this.topicNotificationMap=new HashMap<>();
    }

    @Override 
    public void update(String topicName){
        List<Notification>channels=topicNotificationMap.get(topicName);
        for(Notification channel:channels){
            System.out.println(name + " is notified about "+topicName + " by "+channel.toString());
        }
    }

    @Override 
    public void addTopicChannelMapping(String topic, Notification notification){
        this.topicNotificationMap.computeIfAbsent(topic, k->new ArrayList<>())
                                    .add(notification);
    }
    
    @Override 
    public void updateChannelMapping(String topicName){
        topicNotificationMap.remove(topicName);
    }
}