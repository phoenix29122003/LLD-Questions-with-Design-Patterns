package VendingMachineLLD;

public interface VendingMachineState {
    void showItems(VendingMachine vendingMachine);
    void makeSelection(VendingMachine vendingMachine);
    void insertMoney(VendingMachine vendingMachine);
    void despenseProduct(VendingMachine vendingMachine);
    void cancel(VendingMachine vendingMachine);
}
