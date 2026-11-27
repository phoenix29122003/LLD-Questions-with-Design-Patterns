package BookMyShowLLD;

import java.util.UUID;

public class Seat {
    public String id;
    public Integer number;

    public Seat(Integer number){
        this.id=UUID.randomUUID().toString();
        this.number=number;
    }
}
