package ZomatoLLD;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Restaurant {
    public String id;
    public String name;
    public String address;
    public Map<Item,Integer>menu;

    public Restaurant(String name, String address){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.address=address;
        this.menu=new HashMap<>();
    }

    public void addMenuItem(Item item,Integer count){
        this.menu.put(item, count);
    }

    public void showMenu(){
        System.out.println("Here is menu for restaurant: "+ this.name);
        for(Item item:menu.keySet()){
            System.out.println("Item: "+item.name + " Price: "+item.price + " Quantity: "+menu.get(item));
        }
    }

    public void updateInventory(Map<Item,Integer>itemList){
        for(Item item:itemList.keySet()){
            Integer quantity=itemList.get(item);
            menu.put(item, menu.get(item)-quantity);
        }
    }

    public void restoreInventory(Map<Item,Integer>itemList){
        for(Item item:itemList.keySet()){
            Integer quantity=itemList.get(item);
            menu.put(item, menu.get(item)+quantity);
        }
    }
}
