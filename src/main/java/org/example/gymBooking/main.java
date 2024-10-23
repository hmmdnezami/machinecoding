package org.example.gymBooking;

import org.example.gymBooking.Exceptions.EmailNotFoundException;
import org.example.gymBooking.entity.Booking;
import org.example.gymBooking.entity.WorkoutType;
import org.example.gymBooking.helpers.DateConvertor;
import org.example.gymBooking.helpers.WorkOutFactory;
import org.example.gymBooking.service.BookingService;
import org.example.gymBooking.service.CentreService;
import org.example.gymBooking.service.UserServicce;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) throws EmailNotFoundException {

        UserServicce userServicce = UserServicce.getInstance();
        CentreService centreService = CentreService.getInstance();
        BookingService bookingService = BookingService.getInstance();

        int userId = userServicce.registerUser("Mohit", "mohit@gmail.com", "HSR") ;
        centreService.addCentre("Kormangala", 5, WorkOutFactory.createWorkoutType("Weights"), 9, 10, "11/09/2024", "25/09/2024");
        centreService.addCentre("Kormangala", 5, WorkOutFactory.createWorkoutType("Cardio"), 10, 11, "11/09/2024", "25/09/2024");

        Booking booking = bookingService.bookSession("mohit@gmail.com", "Kormangala", "Weights", 9, 10, "20/09/2024");


        System.out.println(userId);

        if (booking != null)
            System.out.println(booking.getCentre().getName() + " " + booking.getSlots().getStartTime());

        userServicce.viewSchedule("mohit@gmail.com", "20/09/2024") ;
    }
}

//    addCentre(String name, int maximumCapacity, WorkoutType workoutType, int startTime, int endTime, String startDate, String endDate)