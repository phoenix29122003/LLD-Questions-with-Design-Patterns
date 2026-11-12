package ParkingLotDesign;

import java.time.Instant;
import java.util.UUID;

public class Ticket {
    public String ticketNumber;
    public Vehicle vehicle;
    public ParkingSpot parkingSpot;
    public Instant currentTimeStamp;
    public TicketStatus ticketStatus;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.ticketNumber=UUID.randomUUID().toString();
        this.vehicle=vehicle;
        this.parkingSpot=parkingSpot;
        this.currentTimeStamp=Instant.now();
        this.ticketStatus=TicketStatus.ACTIVE;
    }

    public String getTicketNumber(){
        return this.ticketNumber;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public ParkingSpot getParkingSpot(){
        return this.parkingSpot;
    }

    public Instant getParkingTimeStamp(){
        return this.currentTimeStamp;
    }

    public void setStatus(TicketStatus ticketStatus){
        this.ticketStatus=ticketStatus;
    }

    public TicketStatus getTicketStatus(){
        return this.ticketStatus;
    }
}
