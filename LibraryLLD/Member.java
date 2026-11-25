package LibraryLLD;

import java.util.UUID;

public class Member {
    public String id;
    public String name;

    public Member(String name){
        this.id=UUID.randomUUID().toString();
        this.name=name;
    }
}
