package BookMyShowLLD;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Show {
    public String id;
    public Movie movie;
    public Screen screen;
    public Threatre threatre;
    public LocalTime startTime;
    public LocalDate date;
    public Set<Seat>reservedSeats;

    public Show(Movie movie, Screen screen, Threatre threatre, LocalTime startTime, LocalDate date){
        this.id=UUID.randomUUID().toString();
        this.movie=movie;
        this.screen=screen;
        this.threatre=threatre;
        this.startTime=startTime;
        this.date=date;
        this.reservedSeats=new HashSet<>();
    }

    public void markSeatReserved(Map<String,Seat>seats){
        for(Seat seat:seats.values()){
            this.reservedSeats.add(seat);
        }
    }

    public void removeReservation(Seat seat){
        this.reservedSeats.remove(seat);
    }
}
