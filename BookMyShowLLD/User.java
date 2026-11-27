package BookMyShowLLD;

import java.util.UUID;

public class User {
    public String id;
    public String name;

    public User(String name){
        this.id=UUID.randomUUID().toString();
        this.name=name;
    }
}
