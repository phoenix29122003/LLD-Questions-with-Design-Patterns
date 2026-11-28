package UberLLD;

import java.util.UUID;

public class Rider {
    public String id;
    public String name;

    public Rider(String name){
        this.id=UUID.randomUUID().toString();
        this.name=name;
    }
}
