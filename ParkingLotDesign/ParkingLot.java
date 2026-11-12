package ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public List parkingFloors;

    public ParkingLot(){
        this.parkingFloors=new ArrayList<>();
    }

    public void addParkingFloor(ParkingFloor parkingFloor){
        this.parkingFloors.add(parkingFloor);
    }

    public List<ParkingFloor> getFloors(){
        return this.parkingFloors;
    }
}
