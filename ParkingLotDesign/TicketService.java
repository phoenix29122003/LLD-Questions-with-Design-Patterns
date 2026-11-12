package ParkingLotDesign;

public class TicketService {
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        return new Ticket(vehicle, parkingSpot);
    }
}
