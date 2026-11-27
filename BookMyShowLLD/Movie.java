package BookMyShowLLD;

import java.util.UUID;

public class Movie {
    public String id;
    public String name;
    public Integer duration;

    public Movie(String name,Integer duration){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.duration=duration;
    }
}
