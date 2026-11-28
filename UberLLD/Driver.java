package UberLLD;

import java.util.UUID;

public class Driver {
    public String id;
    public String name;
    public DriverStatus status;
    public Location location;

    public Driver(String name){
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.status=DriverStatus.AVAILABLE;
        this.location=null;
    }

    public void setAvailability(DriverStatus status){
        this.status=status;
    }

    public void setCurrentLocation(double latitude, double longitude){
        this.location=new Location(latitude, longitude);
    }
}
