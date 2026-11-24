package ZomatoLLD;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    public String restaurantId;
    public Map<Item,Integer>itemList;

    public Cart(){
        this.restaurantId=null;
        this.itemList=new HashMap<>();
    }

    public void addToCart(String restaurantId,Item item){
        if(this.restaurantId==null && itemList.size()==0){
            this.restaurantId=restaurantId;
        }
        else if(!this.restaurantId.equals(restaurantId)){
            this.itemList=new HashMap<>();
            this.restaurantId=restaurantId;
        }
        this.itemList.merge(item, 1, Integer::sum);
    }
}
