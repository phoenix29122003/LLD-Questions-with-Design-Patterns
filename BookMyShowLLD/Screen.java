package BookMyShowLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Screen {
    public String id;
    public String name;
    public Map<String,Seat> seats;

    public Screen(String name){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.seats=new HashMap<>();
    }

    public void addSeats(Map<String,Seat>seats){
        this.seats=seats;
    }
}
