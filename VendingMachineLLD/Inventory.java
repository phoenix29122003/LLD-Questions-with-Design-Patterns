package VendingMachineLLD;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public Map<Item,Integer>inventoryMap;

    public Inventory() {
        inventoryMap = new HashMap<>();

        inventoryMap.put(new Item(1, "Coke", 40), 10);
        inventoryMap.put(new Item(2, "Pepsi", 35), 8);
        inventoryMap.put(new Item(3, "Water", 20), 15);
        inventoryMap.put(new Item(4, "Chips", 25), 5);
    }
}
