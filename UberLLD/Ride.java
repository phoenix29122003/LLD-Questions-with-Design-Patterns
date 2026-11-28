package UberLLD;

import java.util.UUID;

public class Ride {
    public String id;
    public Rider rider;
    public Driver driver;
    public Location pickupLocation;
    public Location dropLocation;
    public RideStatus status;

    public Ride(Rider rider, Location pickLocation, Location dropLocation){
        this.id=UUID.randomUUID().toString();
        this.rider=rider;
        this.driver=null;
        this.pickupLocation=pickLocation;
        this.dropLocation=dropLocation;
        this.status=RideStatus.REQUESTED;
    }
}
