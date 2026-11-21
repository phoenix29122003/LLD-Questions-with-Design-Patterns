package VendingMachineLLD;

public class VendingMachine {
    public Inventory inventory;
    public Item selectedItem;
    public Integer insertedAmount;
    public VendingMachineState currentState;

    public VendingMachine(){
        this.inventory=new Inventory();
        this.selectedItem=null;
        this.insertedAmount=0;
        this.currentState=new IdleState();
    }

    public void setState(VendingMachineState vendingMchineState){
        this.currentState=vendingMchineState;
    }

    public void showItems(){
        this.currentState.showItems(this);
    }

    public void makeSelection(){
        this.currentState.makeSelection(this);
    }

    public void insertMoney(){
        this.currentState.insertMoney(this);
    }

    public void despense(){
        this.currentState.despenseProduct(this);
    }

    public void cancelOrder(){
        this.currentState.cancel(this);
    }
}
