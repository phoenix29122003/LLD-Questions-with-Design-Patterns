package VendingMachineLLD;

public class Item {
    public Integer itemCode;
    public String itemName;
    public Integer price;

    public Item(Integer itemCode, String itemName, Integer price){
        this.itemCode=itemCode;
        this.itemName=itemName;
        this.price=price;
    }
}
