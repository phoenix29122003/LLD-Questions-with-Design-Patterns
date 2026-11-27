package BookMyShowLLD;

import java.util.List;
import java.util.UUID;

public class Booking {
    public String id;
    public User user;
    public Show show;
    public List<Seat>selectedSeats;
    public BookingStatus status;

    public Booking(User user, Show show, List<Seat> selectedSeats){
        this.id=UUID.randomUUID().toString();
        this.user=user;
        this.show=show;
        this.selectedSeats=selectedSeats;
        this.status=BookingStatus.SUCCESSFUL;
    }
}
