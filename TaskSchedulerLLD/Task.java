package TaskSchedulerLLD;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    public String id;
    public String name;
    public LocalDateTime scheduledTime;
    public TaskStatus status;

    public Task(String name, LocalDateTime scheduledTime){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.scheduledTime=scheduledTime;
        this.status=TaskStatus.SCHEDULED;
    }
}
