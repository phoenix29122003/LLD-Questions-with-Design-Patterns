package UberLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uber {
    public Map<String,Rider>riders;
    public Map<String,Driver>drivers;
    public Map<String,Ride>rides;

    public Uber(){
        this.riders=new HashMap<>();
        this.drivers=new HashMap<>();
        this.rides=new HashMap<>();
    }

    public Rider registerRider(String name){
        Rider rider=new Rider(name);
        riders.put(rider.id, rider);
        System.out.println("Rider: "+rider.name + " registered.");
        return rider;
    }

    public Driver registerDriver(String name){
        Driver driver=new Driver(name);
        drivers.put(driver.id, driver);
        System.out.println("Driver: "+driver.name + " registered.");
        return driver;
    }

    public void setAvailability(String driverId, DriverStatus status){
        Driver driver=drivers.get(driverId);
        driver.setAvailability(status);
        System.out.println("Driver: "+driver.name + " availability set to: "+ status.toString());
    }

    public void setLocation(String driverId, double latitude, double longitude){
        Driver driver=drivers.get(driverId);
        driver.setCurrentLocation(latitude, longitude);
        System.out.println("Driver: "+driver.name + " location is set.");
        System.out.println("Latitude: "+latitude);
        System.out.println("Longitude: "+longitude);
    }

    public Ride requestRide(String riderId, Location pickLocation, Location dropLocation){
        Rider rider=riders.get(riderId);
        Ride ride=new Ride(rider, pickLocation, dropLocation);
        rides.put(ride.id, ride);
        System.out.println("Ride requested by: "+rider.name);
        return ride;
    }

    public List<Driver> findNearByDrivers(String rideId){
        List<Driver>availableDrivers=new ArrayList<>();
        Ride ride=rides.get(rideId);
        Location location1=ride.pickupLocation;
        
        for(Driver driver:drivers.values()){
            if(driver.status.equals(DriverStatus.AVAILABLE)){
                Location location2=driver.location;
                double lat1 = Math.toRadians(location1.latitute);
                double lon1 = Math.toRadians(location1.longitute);
                double lat2 = Math.toRadians(location2.latitute);
                double lon2 = Math.toRadians(location2.longitute);

                double dLat = lat2 - lat1;
                double dLon = lon2 - lon1;

                double a = Math.pow(Math.sin(dLat / 2), 2)
                        + Math.cos(lat1) * Math.cos(lat2)
                        * Math.pow(Math.sin(dLon / 2), 2);

                double distance = 2 * 6371 * Math.asin(Math.sqrt(a)); 

                if(distance<=5.0000){
                    availableDrivers.add(driver);
                }
            }
        }

        if(availableDrivers.size()>0){
            System.out.println("Number of available drivers found: "+availableDrivers.size());
            for(Driver driver:availableDrivers){
                System.out.println("Driver name: "+driver.name);
            }
        }

        return availableDrivers;
    }

    public void acceptRide(String driverId,String rideId){
        Driver driver=drivers.get(driverId);
        Ride ride=rides.get(rideId);

        if(ride.driver!=null){
            System.out.println("One driver already accepted the ride. You cannot accept");
            return;
        }

        if(driver.status.equals(DriverStatus.UNAVAILABLE)){
            System.out.println(driver.name + " your status is unavailable. You cannot accept the ride");
            return;
        }

        ride.driver=driver;
        ride.status=RideStatus.ACCEPTED;
        driver.setAvailability(DriverStatus.UNAVAILABLE);

        System.out.println(ride.id + " is accepted by driver: "+driver.name);
    }

    public void startRide(String driverId, String rideId){
        Driver driver=drivers.get(driverId);
        Ride ride=rides.get(rideId);

        if(!ride.driver.equals(driver)){
            System.out.println("You cannot start the ride.");
            return;
        }

        if(!ride.status.equals(RideStatus.ACCEPTED)){
            System.out.println("Ride cannot be started as it is not accepted");
            return;
        }
        ride.status=RideStatus.STARTED;
        System.out.println(ride.id + " started by driver: "+driver.name);
    }

    public void completeRide(String driverId, String rideId){
        Driver driver=drivers.get(driverId);
        Ride ride=rides.get(rideId);

        if(!ride.driver.equals(driver)){
            System.out.println("You cannot end the ride.");
            return;
        }

        if(!ride.status.equals(RideStatus.STARTED)){
            System.out.println("Ride cannot be end as it was not started.");
            return;
        }
        ride.status=RideStatus.TERMINATED;
        driver.status=DriverStatus.AVAILABLE;
        System.out.println(ride.id + " terminated by driver: "+driver.name);
    }

    public void cancelRide(String riderId, String rideId){
        Rider rider=riders.get(riderId);
        Ride ride=rides.get(rideId);

        if(!ride.status.equals(RideStatus.REQUESTED) && !ride.status.equals(RideStatus.ACCEPTED)){
            System.out.println("You cannot cancel the ride");
            return;
        }

        if(!ride.rider.equals(rider)){
            System.out.println("You cannot cancel the ride");
            return;
        }

        if(ride.status.equals(RideStatus.ACCEPTED)){
            ride.driver.status=DriverStatus.AVAILABLE;
            ride.status=RideStatus.CANCELLED;
        }

        if(ride.status.equals(RideStatus.REQUESTED)){
            ride.status=RideStatus.CANCELLED;
        }
    }

    public void showRide(String rideId){
        Ride ride=rides.get(rideId);

        System.out.println("Here is the ride details: ");
        System.out.println("Rider: "+ride.rider.name);
        if(ride.driver!=null){
            System.out.println("Driver: "+ride.driver.name);
        }
        System.out.println("Status: "+ride.status.toString());
        System.out.println("Pickup Location: "+ ride.pickupLocation.latitute + " " + ride.pickupLocation.longitute);
        System.out.println("Drop Location: "+ ride.dropLocation.latitute + " "+ ride.dropLocation.longitute);
    }
}
