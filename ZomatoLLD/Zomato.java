package ZomatoLLD;

import java.util.HashMap;
import java.util.Map;

public class Zomato {
    public Map<String,User>users;
    public Map<String,Restaurant>restaurants;
    public Map<String,Order>orders;

    public Zomato(){
        this.users=new HashMap<>();
        this.restaurants=new HashMap<>();
        this.orders=new HashMap<>();
    }

    public User registerUser(String name){
        User user=new User(name);
        this.users.put(user.id, user);
        System.out.println("User: "+ user.name +" registerd");
        return user;
    }

    public Restaurant registerRestaurant(String name, String address){
        Restaurant restaurant=new Restaurant(name, address);
        this.restaurants.put(restaurant.id, restaurant);
        System.out.println("Restaurant: "+restaurant.name + " registered.");
        return restaurant;
    }

    public Item addItemToMenuToRestaurant(String restaurantId,Item item, Integer quantity){
        Restaurant restaurant=restaurants.get(restaurantId);
        restaurant.addMenuItem(item, quantity);
        System.out.println(item.name + " is added with quantity: " + quantity + " to restaurant: "+restaurant.name);
        return item;
    }

    public void showMenuForRestaurant(String restaurantId){
        Restaurant restaurant=restaurants.get(restaurantId);
        restaurant.showMenu();
    }

    public void addToCart(String userId, String restaurantId, Item item){
        User user=users.get(userId);
        Cart cart=user.cart;
        Restaurant restaurant=restaurants.get(restaurantId);

        Map<Item,Integer>menu=restaurant.menu;
        for(Item itemInMenu:menu.keySet()){
            if(itemInMenu.equals(item) && menu.get(itemInMenu)!=0){
                cart.addToCart(restaurantId, item);
                System.out.println(item.name + " is added to cart.");
                return;
            }
        }

        System.out.println(item.name +" is not available in restaurant.");
    }

    public Order createOrder(String userId){
        Cart cart=users.get(userId).cart;
        String restaurantId=cart.restaurantId;
        Restaurant restaurant=restaurants.get(restaurantId);
        Map<Item,Integer>itemList=new HashMap<>(cart.itemList);
        if(itemList.size()==0){
            System.out.println("Cart is empty. Cannot create order.");
            return null;
        }
        restaurant.updateInventory(itemList);
        Order order=new Order(userId, restaurantId, itemList);
        orders.put(order.id, order);
        cart.restaurantId=null;
        cart.itemList=new HashMap<>();
        System.out.println("Order created with orderId: "+order.id);
        return order;
    }

    public Integer checkoutOrder(String orderId){
        Integer amount=0;
        Order order=orders.get(orderId);
        Map<Item,Integer>itemList=order.items;
        for(Item item:itemList.keySet()){
            amount+=item.price*itemList.get(item);
        }
        System.out.println("Amount to be paid: "+amount);
        return amount;
    }

    public void processPayment(Integer amount){
        System.out.println("Payment processed for amount: "+amount);
    }

    public void acceptOrder(String orderId){
        Order order=orders.get(orderId);
        if(order.status.equals(OrderStatus.PENDING)){
            order.status=OrderStatus.ACCEPTED;
            System.out.println("Order is accepted by restaurant.");
        }
    }

    public void rejectOrder(String orderId){
        Order order=orders.get(orderId);
        if(order.status.equals(OrderStatus.PENDING)){
            order.status=OrderStatus.REJECTED;
            Restaurant restaurant=restaurants.get(order.restaurantId);
            restaurant.restoreInventory(order.items);
            System.out.println("Order is rejected by restaurant.");
        }
    }

    public void viewOrder(String orderId){
        Order order=orders.get(orderId);
        System.out.println("Printing order details.");
        order.printOrderDetails();
    }
}
