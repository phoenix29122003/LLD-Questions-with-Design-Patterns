package VendingMachineLLD;

import java.util.Map;
import java.util.Scanner;

public class ProductSelectedState implements VendingMachineState{
    @Override 
    public void showItems(VendingMachine vendingMachine){
        Inventory inventory=vendingMachine.inventory;

        System.out.println("Here are items for vending machine.");
        System.out.println();
        
        Map<Item,Integer>inventoryMap=inventory.inventoryMap;

        for(Item item:inventoryMap.keySet()){
            System.out.println("Item code: "+item.itemCode +" Item name: "+item.itemName + " Item price: "+ item.price);
        }
    }

    @Override 
    public void makeSelection(VendingMachine vendingMachine){
        System.out.println("You have already selected one item. Cannot make another selection without termination.");
    }

    @Override 
    public void insertMoney(VendingMachine vendingMachine){
        System.out.println("Enter " +vendingMachine.selectedItem.price+  " to purchase the item: "+ vendingMachine.selectedItem.itemName);
        Scanner sc=new Scanner(System.in);
        Integer inputAmount=sc.nextInt();
        vendingMachine.insertedAmount=inputAmount;
        HasMoneyState hasMoneyState=new HasMoneyState();
        vendingMachine.setState(hasMoneyState);
        System.out.println(vendingMachine.insertedAmount + " money amount inserted.");
        if(vendingMachine.currentState==hasMoneyState){
            System.out.println("Vending machine entered to has money state.");
        }
    }

    @Override 
    public void despenseProduct(VendingMachine vendingMachine){
        System.out.println("To despense item, first enter money");
    }

    @Override 
    public void cancel(VendingMachine vendingMachine){
        System.out.println("Cancelling item selection: "+vendingMachine.selectedItem.itemName);
        vendingMachine.selectedItem=null;
        vendingMachine.insertedAmount=0;
        IdleState idleState=new IdleState();
        vendingMachine.setState(idleState);
    }

}
