package TaskSchedulerLLD;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public Map<String,Task>tasks;

    public TaskScheduler(){
        this.tasks=new HashMap<>();
    }

    public Task createTask(String name, LocalDateTime scheduledTime){
        Task task=new Task(name, scheduledTime);
        this.tasks.put(task.id, task);
        System.out.println(task.name + " is scheduled at: "+scheduledTime);
        return task;
    }

    public void executeTask(){
        for(Task task:tasks.values()){
            if(task.status.equals(TaskStatus.SCHEDULED)){
                if(task.scheduledTime.isBefore(LocalDateTime.now()) || task.scheduledTime.isEqual(LocalDateTime.now())){
                    task.status=TaskStatus.COMPLETED;
                    System.out.println("Task: "+task.name + " is executed.");
                }
            }
        }
    }

    public void cancelTask(String taskId){
        Task task=tasks.get(taskId);
        if(task.status.equals(TaskStatus.SCHEDULED)){
            task.status=TaskStatus.CANCELLED;
            System.out.println("Task: "+task.name + " is cancelled");
        }
    }

    public void viewTask(String taskId){
        Task task=tasks.get(taskId);

        System.out.println("Here are task details");
        System.out.println("TaskId: "+task.id);
        System.out.println("Task name: "+task.name);
        System.out.println("Task Scheduled Time: "+task.scheduledTime);
        System.out.println("Task Status: "+task.status.toString());
    }

    public Task rescheduleTask(String taskId, LocalDateTime newTime){
        Task task=tasks.get(taskId);
        if(!task.status.equals(TaskStatus.SCHEDULED)){
            System.out.println("This task cannot be rescheduled");
            return null;
        }

        task.scheduledTime=newTime;
        System.out.println("Task: "+task.name + " is rescheduled to new time: "+newTime);
        return task;
    }

    public void viewAllTask(){
        for(Task task:tasks.values()){
            System.out.println("Task name: "+task.name + " Task status: "+task.status.toString() + " Scheduled time: "+task.scheduledTime);
        }
    }
}
