package ParkingLotDesign;

public class ParkingSpot {
    public String parkingSpotNumber;
    public VehicleType vehicleType;
    public ParkingSpotStatus parkingSpotStatus;

    public ParkingSpot(String parkingSpotNumber, VehicleType vehicleType){
        this.parkingSpotNumber=parkingSpotNumber;
        this.parkingSpotStatus=ParkingSpotStatus.AVAILABLE;
        this.vehicleType=vehicleType;
    }

    public String getParkingSpotNumber(){
        return this.parkingSpotNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus(){
        return this.parkingSpotStatus;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus){
        this.parkingSpotStatus=parkingSpotStatus;
    }
}
