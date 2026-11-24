package ZomatoLLD;

import java.util.Map;
import java.util.UUID;

public class Order {
    public String id;
    public String userId;
    public String restaurantId;
    public Map<Item,Integer>items;
    public OrderStatus status;

    public Order(String userId,String restaurantId, Map<Item,Integer>items){
        this.id=UUID.randomUUID().toString();
        this.userId=userId;
        this.restaurantId=restaurantId;
        this.items=items;
        this.status=OrderStatus.PENDING;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + id);
        System.out.println("User ID: " + userId);
        System.out.println("Restaurant ID: " + restaurantId);
        System.out.println("Status: " + status);

        int total = 0;
        System.out.println("Items:");

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(item.name + " x " + quantity
                    + " = " + (item.price * quantity));

            total += item.price * quantity;
        }

        System.out.println("Total Amount: " + total);
    }
}
