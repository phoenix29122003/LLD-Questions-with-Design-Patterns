package NotificationSystemDesign;

public interface Observer {
    void update(String message);
    void updateChannelMapping(String topicName);
    void addTopicChannelMapping(String topicName, Notification notification);
}
