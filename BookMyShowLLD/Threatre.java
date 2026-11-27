package BookMyShowLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Threatre {
    public String id;
    public String name;
    public String location;
    public Map<String,Screen>screens;

    public Threatre(String name, String location){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.location=location;
        this.screens=new HashMap<>();
    }

    public Screen addScreen(Screen screen){
        this.screens.put(screen.id, screen);
        return screen;
    }
}
