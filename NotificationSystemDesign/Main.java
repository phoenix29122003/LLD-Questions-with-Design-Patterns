package NotificationSystemDesign;

public class Main {
    public static void main(String args[]){
        Topic1 topic1=new Topic1("topic1");
        Topic2 topic2=new Topic2("topic2");

        User1 user1=new User1("user1");
        User2 user2=new User2("user2");
        User3 user3=new User3("user3");

        topic1.addObserver(user1);
        topic1.addObserver(user2);

        topic2.addObserver(user3);

        user1.addTopicChannelMapping("topic1",Notification.SMS);
        user1.addTopicChannelMapping("topic1",Notification.EMAIL);

        user2.addTopicChannelMapping("topic1", Notification.PUSH);

        user3.addTopicChannelMapping("topic2", Notification.SMS);
        user3.addTopicChannelMapping("topic2", Notification.PUSH);

        topic1.notifyAllObservers();
        topic2.notifyAllObservers();

        System.out.println("user2 unsubscribed from topic1");
        topic1.removeObserver(user2);
        topic1.notifyAllObservers();
        topic2.notifyAllObservers();
    }
}
