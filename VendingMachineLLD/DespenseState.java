package VendingMachineLLD;

import java.util.Map;

public class DespenseState implements VendingMachineState{
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
        System.out.println("Item is in state of despense. Don't enter money in between process.");
    }

    @Override 
    public void despenseProduct(VendingMachine vendingMachine){
        System.out.println(vendingMachine.selectedItem.itemName + " despended.");
        if(vendingMachine.insertedAmount - vendingMachine.selectedItem.price >0){
            System.out.println(vendingMachine.insertedAmount - vendingMachine.selectedItem.price + " change despensed.");
        }
        
        IdleState idleState=new IdleState();
        vendingMachine.setState(idleState);
        vendingMachine.inventory.inventoryMap.put(
            vendingMachine.selectedItem,
            vendingMachine.inventory.inventoryMap.get(vendingMachine.selectedItem) - 1
        );
        vendingMachine.selectedItem=null;
        vendingMachine.insertedAmount=0;
    }

    @Override 
    public void cancel(VendingMachine vendingMachine){
        System.out.println("Now you cannot cancel order. Item is in despense state.");
    }
}
