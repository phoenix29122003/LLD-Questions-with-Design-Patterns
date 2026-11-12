package ParkingLotDesign;

import java.util.List;

public class Main {
    public static void main(String args[]){
        Vehicle bike=new Vehicle("123", VehicleType.BIKE);
        Vehicle car=new Vehicle("456", VehicleType.CAR);
        Vehicle truck=new Vehicle("789", VehicleType.TRUCK);

        ParkingSpot bikeSpot1=new ParkingSpot("1", VehicleType.BIKE);
        ParkingSpot carSpot1=new ParkingSpot("2", VehicleType.CAR);
        ParkingSpot truckSpot1=new ParkingSpot("3", VehicleType.TRUCK);

        ParkingFloor parkingFloor1=new ParkingFloor("ParkingFloor1");
        parkingFloor1.addParkingSpot(bikeSpot1);
        parkingFloor1.addParkingSpot(carSpot1);
        parkingFloor1.addParkingSpot(truckSpot1);

        ParkingSpot bikeSpot2=new ParkingSpot("4", VehicleType.BIKE);
        ParkingSpot carSpot2=new ParkingSpot("5", VehicleType.CAR);
        ParkingSpot truckSpot2=new ParkingSpot("6", VehicleType.TRUCK);

        ParkingFloor parkingFloor2=new ParkingFloor("ParkingFloor2");
        parkingFloor2.addParkingSpot(bikeSpot2);
        parkingFloor2.addParkingSpot(carSpot2);
        parkingFloor2.addParkingSpot(truckSpot2);


        ParkingSpot bikeSpot3=new ParkingSpot("7", VehicleType.BIKE);
        ParkingSpot carSpot3=new ParkingSpot("8", VehicleType.CAR);
        ParkingSpot truckSpot3=new ParkingSpot("9", VehicleType.TRUCK);

        ParkingFloor parkingFloor3=new ParkingFloor("ParkingFloor3");
        parkingFloor3.addParkingSpot(bikeSpot3);
        parkingFloor3.addParkingSpot(carSpot3);
        parkingFloor3.addParkingSpot(truckSpot3);

        ParkingLot parkingLot=new ParkingLot();
        parkingLot.addParkingFloor(parkingFloor1);
        parkingLot.addParkingFloor(parkingFloor2);
        parkingLot.addParkingFloor(parkingFloor3);

        AvailabilityService availabilityService=new AvailabilityService(parkingLot);
        PaymentService paymentService=new PaymentService();
        paymentService.setPaymentStrategy(new CardPaymentStrategy());
        ParkingLotManager parkingLotManager=new ParkingLotManager(availabilityService, paymentService);

        List<ParkingSpot> availableBikeSpots=parkingLotManager.getAvailableSpots(VehicleType.BIKE);
        System.out.println("Available spots for bikes are below: " + availableBikeSpots.size());
        for(ParkingSpot spot:availableBikeSpots){
            System.out.println("Spot Number: "+spot.getParkingSpotNumber());
        }

        List<ParkingSpot> availableCarSpots=parkingLotManager.getAvailableSpots(VehicleType.CAR);
        System.out.println("Available spots for cars are below: " + availableCarSpots.size());
        for(ParkingSpot spot:availableCarSpots){
            System.out.println("Spot Number: "+spot.getParkingSpotNumber());
        }

        List<ParkingSpot> availableTruckSpots=parkingLotManager.getAvailableSpots(VehicleType.TRUCK);
        System.out.println("Available spots for trucks are below: " + availableTruckSpots.size());
        for(ParkingSpot spot:availableTruckSpots){
            System.out.println("Spot Number: "+spot.getParkingSpotNumber());
        }

        Ticket ticket=parkingLotManager.parkVehicle(bike);
        if(ticket!=null){
            System.out.println("Vehicle Parked. Generated ticket number : "+ticket.getTicketNumber());
        }

        Double fee=parkingLotManager.unparkVehicle(ticket);
        System.out.println("Fee: "+fee);

        parkingLotManager.makePayment(fee);
    }
}
