package VendingMachineLLD;

import java.util.Map;
import java.util.Scanner;

public class HasMoneyState implements VendingMachineState{
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
        System.out.println("One item already selected. You cannot select one more item without termination.");
    }

    @Override 
    public void insertMoney(VendingMachine vendingMachine){
        System.out.println("Money is already inserted. Don't try to insert money in between process.");
    }

    @Override 
    public void despenseProduct(VendingMachine vendingMachine){
        Integer amountInserted=vendingMachine.insertedAmount;
        Integer selectedItemPrice=vendingMachine.selectedItem.price;
        if(amountInserted>=selectedItemPrice){
            VendingMachineState despenseState=new DespenseState();
            vendingMachine.setState(despenseState);
            if(vendingMachine.currentState==despenseState){
                System.out.println("Vending machine has entered despense state.");
                vendingMachine.despense();
            }
        }
        else{
            System.out.println("Entered amount: "+amountInserted + " is less than item amount. Insert more money.");
            Scanner sc=new Scanner(System.in);
            Integer moreMoney=sc.nextInt();
            vendingMachine.insertedAmount+=moreMoney;
            despenseProduct(vendingMachine);
        }
    }

    @Override 
    public void cancel(VendingMachine vendingMachine){
        System.out.println("Item selection cancelled. Item: "+ vendingMachine.selectedItem.itemName + " Now refunding money. "+ vendingMachine.insertedAmount);
        vendingMachine.selectedItem=null;
        vendingMachine.insertedAmount=0;
        IdleState idleState=new IdleState();
        vendingMachine.setState(idleState);
    }
}
