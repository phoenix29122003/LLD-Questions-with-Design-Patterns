package ParkingLotDesign;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class ParkingLotManager {
    public PaymentService paymentService;
    public AvailabilityService availabilityService;
    public TicketService ticketService;
    public ParkingSpotType parkingSpotType;

    public ParkingLotManager(AvailabilityService availabilityService, PaymentService paymentService){
        this.paymentService=paymentService;
        this.ticketService=new TicketService();
        this.availabilityService=availabilityService;
    }

    public List<ParkingSpot> getAvailableSpots(VehicleType vechicleType){
        return availabilityService.getAvailableSpots(vechicleType);
    }

    public Ticket parkVehicle(Vehicle vehicle){
        List<ParkingSpot> spots=availabilityService.getAvailableSpots(vehicle.getVehicleType());
        if(spots.size()==0){
            System.out.println("No slots for given vehicle.");
            return null;
        }
        ParkingSpot spot=spots.get(0);
        spot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        return ticketService.generateTicket(vehicle, spot);
    }

    public double unparkVehicle(Ticket ticket){
        if(ticket.getTicketStatus().equals(TicketStatus.INACTIVE)){
            System.out.println("Ticket is already inactive");
            return 0.0;
        }
        double fee=0.0;
        if(ticket.getVehicle().getVehicleType().equals(VehicleType.BIKE)){
            fee=20;
        }
        else if(ticket.getVehicle().getVehicleType().equals(VehicleType.CAR)){
            fee=30;
        }
        else fee=40;

        ticket.getParkingSpot().setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
        ticket.setStatus(TicketStatus.INACTIVE);

        Duration duration=Duration.between(ticket.getParkingTimeStamp(), Instant.now());
        double durationInHours=duration.toHours();
        fee=fee*durationInHours;

        return fee;
    }

    public void makePayment(double amount){
        paymentService.processPayment(amount);
    }
}
