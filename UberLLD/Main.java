package UberLLD;

import java.util.List;

public class Main {
    public static void main(String args[]){
        Uber uber=new Uber();

        Driver driver1=uber.registerDriver("Manu");
        Driver driver2=uber.registerDriver("Janu");
        System.out.println();

        Rider rider=uber.registerRider("Tanu");
        System.out.println();

        uber.setAvailability(driver1.id, DriverStatus.AVAILABLE);
        System.out.println();
        uber.setLocation(driver1.id, 12.9716, 77.5946);
        System.out.println();

        uber.setAvailability(driver2.id, DriverStatus.AVAILABLE);
        System.out.println();
        uber.setLocation(driver2.id, 12.8996, 77.5946);
        System.out.println();

        Location pickLocation=new Location(12.9716, 77.5946);
        Location dropLocation=new Location(12.9352, 77.6245);
        Ride ride=uber.requestRide(rider.id, pickLocation, dropLocation);
        System.out.println();

        List<Driver>drivers=uber.findNearByDrivers(ride.id);
        System.out.println();

        // uber.acceptRide(driver1.id,ride.id);
        // System.out.println();

        // uber.startRide(driver1.id, ride.id);
        // System.out.println();

        // uber.completeRide(driver1.id, ride.id);
        // System.out.println();

        // uber.cancelRide(rider.id, ride.id);

        uber.showRide(ride.id);

    }
}
