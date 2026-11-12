package ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    public String parkingFloorNumber;
    public List parkingSpots;

    public ParkingFloor(String parkingFloorNumber){
        this.parkingFloorNumber=parkingFloorNumber;
        this.parkingSpots=new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    public String getParkingLotNumber(){
        return this.parkingFloorNumber;
    }

    public List<ParkingSpot> getSpots(){
        return this.parkingSpots;
    }
}
