package TaskSchedulerLLD;

import java.time.LocalDateTime;

public class Main {
    public static void main(String args[]){
        TaskScheduler taskScheduler=new TaskScheduler();

        Task pastTask=taskScheduler.createTask("Past Task to send email", LocalDateTime.now().minusMinutes(10));
        Task futureTask=taskScheduler.createTask("Future Task to receive email", LocalDateTime.now().plusMinutes(10));
        System.out.println();

        taskScheduler.cancelTask(pastTask.id);
        System.out.println();

        taskScheduler.executeTask();
        System.out.println();

        taskScheduler.viewTask(pastTask.id);
        System.out.println();

        taskScheduler.rescheduleTask(futureTask.id, LocalDateTime.now().plusHours(1));
        System.out.println();

        taskScheduler.viewAllTask();
    }
}
