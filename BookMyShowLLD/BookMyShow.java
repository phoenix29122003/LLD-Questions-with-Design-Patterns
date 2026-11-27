package BookMyShowLLD;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookMyShow {
    public Map<String,Movie>movies;
    public Map<String,Threatre>threatres;
    public Map<String,Show>shows;
    public Map<String,User>users;
    public Map<String,Booking>bookings;

    public BookMyShow(){
        this.movies=new HashMap<>();
        this.threatres=new HashMap<>();
        this.shows=new HashMap<>();
        this.users=new HashMap<>();
        this.bookings=new HashMap<>();
    }

    public Movie registerMovie(String name, Integer duration){
        Movie movie=new Movie(name, duration);
        this.movies.put(movie.id, movie);
        System.out.println("Movie: "+movie.name + " is registred with duration: "+movie.duration);
        return movie;
    }

    public Threatre registerThreatre(String name, String location){
        Threatre threatre=new Threatre(name, location);
        threatres.put(threatre.id,threatre);
        System.out.println("Threatre: "+threatre.name +" is registered at location: "+threatre.location);
        return threatre;
    } 

    public Screen addScreenToThreatre(String threatreId, String name){
        Screen screen=new Screen(name);
        Threatre threatre=threatres.get(threatreId);
        threatre.addScreen(screen);
        System.out.println(screen.name + " is added to threatre: "+ threatre.name);
        return screen;
    }

    public Map<String,Seat> addSeatsToScreen(String threatreId, String screenId, List<Integer> seatNumbers){
        Threatre threatre = threatres.get(threatreId);
        Screen screen=threatre.screens.get(screenId);
        Map<String,Seat> seats=new HashMap<>();
        for(Integer seatNumber: seatNumbers){
            Seat seat=new Seat(seatNumber);
            seats.put(seat.id, seat);
        }
        screen.addSeats(seats);
        System.out.println("Below seats added to screen: "+screen.name + " and threatre: "+ threatre.name);
        for(Seat seat: seats.values()){
            System.out.print(seat.number + " ");
        }

        return seats;
    }

    public Show registerShow(String threatreId, String screenId, String movieId, LocalDate date, LocalTime time){
        Threatre threatre=threatres.get(threatreId);
        Screen screen=threatre.screens.get(screenId);
        Movie movie=movies.get(movieId);
        Show show=new Show(movie, screen, threatre, time, date);
        shows.put(show.id, show);
        System.out.println("Show is created successfully.");
        System.out.println("Movie: "+movie.name);
        System.out.println("Screen: "+screen.name);
        System.out.println("Threatre: "+threatre.name);
        System.out.println("Date: "+date);
        System.out.println("Time: "+time);

        return show;
    }

    public List<Show> showAvailableShows(String movieId, LocalDate date){
        List<Show> availableShows=new ArrayList<>();
        Movie movie=movies.get(movieId);
        for(Show show:shows.values()){
            if(show.movie.equals(movie) && show.date.equals(date)){
                availableShows.add(show);
            }
        }

        if(availableShows.size()>0){
            System.out.println("Here are the available shows for movie: "+movie.name + " on date: "+date);
            for(Show show:availableShows){
                System.out.println("Movie: "+show.movie.name + " Threatre: "+show.threatre.name + " Screen: "+show.screen.name+" Time: "+show.startTime + " Date: "+show.date);
            }
        }
        return availableShows;
    }

    public User registUser(String name){
        User user=new User(name);
        this.users.put(user.id, user);
        System.out.println(user.name + " is registered successfully");
        return user;
    }

    public Booking bookTickets(String userId, String showId,Map<String,Seat>seats){
        User user=users.get(userId);
        Show show=shows.get(showId);
        Threatre threatre=show.threatre;
        Screen screen=show.screen;
        Set<Seat>reservedSeats=show.reservedSeats;

        for(Seat seat:seats.values()){
            if(reservedSeats.contains(seat)){
                System.out.println("We cannot book this seat collection as few seats are already booked in the show. Please select another combination");
                return null;
            }
        }

        Booking booking=new Booking(user, show, new ArrayList<>(seats.values()));
        bookings.put(booking.id, booking);
        show.markSeatReserved(seats);

        System.out.println("Booking created");
        System.out.println("Booking Id: "+booking.id + " User: "+user.name + " Show: "+show.movie.name);
        return booking;
    }

    public void viewBooking(String bookingId){
        Booking booking=bookings.get(bookingId);

        System.out.println("Here are booking details");

        System.out.println("BookingId: "+bookingId);
        System.out.println("Movie: "+ booking.show.movie.name);
        System.out.println("Threatre: " + booking.show.threatre.name + " Screen: "+booking.show.screen.name);
        System.out.println("Date: "+booking.show.date + " Time: "+booking.show.startTime);
        System.out.println("Booking status: "+booking.status.toString());
        for(Seat seat: booking.selectedSeats){
            System.out.print(seat.number + " ");
        }
    }

    public void cancelBooking(String bookingId){
        Booking booking=bookings.get(bookingId);
        if(booking.status.equals(BookingStatus.CANCELLED)){
            System.out.println("Booking is already cancelled");
            return;
        }

        booking.status=BookingStatus.CANCELLED;
        Show show=booking.show;
        List<Seat> seats=booking.selectedSeats;

        for(Seat seat:seats){
            show.removeReservation(seat);
        }

        System.out.println("Reservation for bookingId: "+bookingId + " is cancelled");
    }
}
