package NotificationSystemDesign;

import java.util.HashSet;
import java.util.Set;

public class Topic2 implements Subject{
    public String name;
    public Set<Observer>observers;

    public Topic2(String name){
        this.name=name;
        this.observers=new HashSet<>();
    }

    @Override 
    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    @Override 
    public void removeObserver(Observer observer){
        observer.updateChannelMapping(name);
        this.observers.remove(observer);
    }

    @Override 
    public void notifyAllObservers(){
        for(Observer observer:observers){
            observer.update(name);
        }
    }
}
