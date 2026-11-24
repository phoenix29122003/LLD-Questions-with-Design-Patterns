package ZomatoLLD;

import java.util.UUID;

public class User {
    public String id;
    public String name;
    public Cart cart;

    public User(String name){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.cart=new Cart();
    }
}
