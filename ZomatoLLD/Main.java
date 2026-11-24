package ZomatoLLD;

public class Main {
    public static void main(String args[]){
        Zomato zomato=new Zomato();

        User user=zomato.registerUser("manu");
        System.out.println();

        Restaurant restaurant=zomato.registerRestaurant("Vishnu Palace", "Mahadevpura");
        System.out.println();

        Item item1=zomato.addItemToMenuToRestaurant(restaurant.id, new Item("Pizza", 250), 10);
        Item item2=zomato.addItemToMenuToRestaurant(restaurant.id, new Item("Burger", 150), 15);
        Item item3=zomato.addItemToMenuToRestaurant(restaurant.id, new Item("Pasta", 200), 8);
        Item item4=zomato.addItemToMenuToRestaurant(restaurant.id, new Item("Sandwich", 120), 12);
        Item item5=zomato.addItemToMenuToRestaurant(restaurant.id, new Item("French Fries", 100), 20);
        System.out.println();

        zomato.showMenuForRestaurant(restaurant.id);
        System.out.println();

        zomato.addToCart(user.id, restaurant.id, item1);
        zomato.addToCart(user.id, restaurant.id, item2);
        zomato.addToCart(user.id, restaurant.id, item3);
        System.out.println();

        Order order=zomato.createOrder(user.id);
        System.out.println();

        Integer amount=zomato.checkoutOrder(order.id);
        System.out.println();

        zomato.processPayment(amount);
        System.out.println();

        zomato.acceptOrder(order.id);
        System.out.println();

        zomato.viewOrder(order.id);
    }
}
