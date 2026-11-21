package VendingMachineLLD;

import java.security.Key;
import java.util.Map;
import java.util.Scanner;

public class IdleState implements VendingMachineState{
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
        System.out.println("Make Item selection.");
        Scanner sc=new Scanner(System.in);
        Integer itemCode=sc.nextInt();
        Inventory inventory=vendingMachine.inventory;
        Map<Item,Integer>inventoryMap=inventory.inventoryMap;

        for(Item item:inventoryMap.keySet()){
            if(item.itemCode.equals(itemCode)){
                vendingMachine.selectedItem=item;
            }
        }

        Item selectedItem=vendingMachine.selectedItem;
        if(selectedItem==null){
            System.out.println("Invalid item code. Enter correct code.");
            makeSelection(vendingMachine);
        }
        else{
            System.out.println("Item selected: "+selectedItem.itemName);
            ProductSelectedState productSelectedState=new ProductSelectedState();
            vendingMachine.setState(productSelectedState);
            if(vendingMachine.currentState==productSelectedState){
                System.out.println();
                System.out.println("Vending Machine has entered product selected state.");
            }
        }
    }

    @Override 
    public void insertMoney(VendingMachine vendingMachine){
        System.out.println("First make some item selection then enter money.");
    }

    @Override 
    public void despenseProduct(VendingMachine vendingMachine){
        System.out.println("To despense item, first make item selection.");
    }

    @Override
    public void cancel(VendingMachine vendingMachine){
        System.out.println("First make selection. Then cancel.");
    }
    
}
