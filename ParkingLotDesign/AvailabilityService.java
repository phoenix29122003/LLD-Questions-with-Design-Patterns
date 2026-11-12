package ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

public class AvailabilityService {
    public ParkingLot parkingLot;

    public AvailabilityService(ParkingLot parkingLot){
        this.parkingLot=parkingLot;
    }

    public List<ParkingSpot> getAvailableSpots(VehicleType vehicleType){
        List<ParkingSpot> availableSpots=new ArrayList<>();
        for(ParkingFloor floor:parkingLot.getFloors()){
            for(ParkingSpot spot:floor.getSpots()){
                if(spot.getVehicleType().equals(vehicleType) && spot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    availableSpots.add(spot);
                }
            }
        }

        return availableSpots;
    }

    public void markSpotAsOccupied(ParkingSpot spot){
        spot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
    }
}
