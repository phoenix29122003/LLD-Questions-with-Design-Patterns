package BookMyShowLLD;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String args[]){
        BookMyShow system=new BookMyShow();

        Movie movie=system.registerMovie("Vinland Saga", 120);
        System.out.println();

        Threatre threatre=system.registerThreatre("VR Bangaluru", "BLR");
        System.out.println();

        Screen screen=system.addScreenToThreatre(threatre.id, "Screen1");
        System.out.println();

        List<Integer>seatNumbers=List.of(1,2,3,4);
        Map<String,Seat>seats=system.addSeatsToScreen(threatre.id, screen.id, seatNumbers);
        System.out.println();

        Show show=system.registerShow(threatre.id, screen.id, movie.id, LocalDate.now(), LocalTime.now());
        System.out.println();

        List<Show>shows=system.showAvailableShows(movie.id,LocalDate.now());
        System.out.println();

        User user=system.registUser("Manu");
        System.out.println();

        Booking booking=system.bookTickets(user.id,show.id,seats);
        System.out.println();

        system.viewBooking(booking.id);
        System.out.println();

        system.cancelBooking(booking.id);
    }
}
