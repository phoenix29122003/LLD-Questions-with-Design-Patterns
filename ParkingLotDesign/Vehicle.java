package ParkingLotDesign;

public class Vehicle {
    public String vehicleNumber;
    public VehicleType vehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType){
        this.vehicleNumber=vehicleNumber;
        this.vehicleType=vehicleType;
    }

    public String getVehicleNumber(){
        return this.vehicleNumber;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
}
