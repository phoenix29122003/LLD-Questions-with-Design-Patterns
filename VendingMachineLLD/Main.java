package VendingMachineLLD;

public class Main {
    public static void main(String args[]){
        VendingMachine vendingMachine=new VendingMachine();
        vendingMachine.showItems();
        vendingMachine.makeSelection();
        vendingMachine.insertMoney();
        vendingMachine.despense();

        vendingMachine.makeSelection();
        vendingMachine.cancelOrder();
    }
}
