package org.example.gymBooking.service;

import org.example.gymBooking.Interface.IBookingService;
import org.example.gymBooking.entity.*;
import org.example.gymBooking.helpers.DateConvertor;
import org.example.gymBooking.helpers.UniqueId;
import org.example.gymBooking.helpers.WorkOutFactory;

import java.util.List;

public class BookingService implements IBookingService {

    private static BookingService instance;

    private BookingService(){};

    UserServicce userServicce = UserServicce.getInstance();

    CentreService centreService = CentreService.getInstance();

    private  UniqueId uniqueId = new UniqueId();

    public static BookingService getInstance() {
        if (instance == null)  instance = new BookingService();
        return instance ;
    }

    @Override
    public Booking bookSession(String email, String workoutLocation, String workoutType, int startTime, int endTime, String date) {


        User user = userServicce.getUser(email) ;
        Centre centre = centreService.getCentre(workoutLocation) ;
        WorkoutType workoutType1 = WorkOutFactory.createWorkoutType(workoutType);

        if (user == null ) {
            System.out.println("user doesnot exist");
            return null;
        }
        if (centre == null ) {
            System.out.println("centre doesnot exist");
            return null ;
        }
        Booking booking = null;
        for (Slots slots : centre.getSlots()) {
            if (slots.getWorkoutType().getClass().equals(workoutType1.getClass()) &&  slots.isAvailable() && slots.getStartTime() <= startTime && slots.getEndTime() >= endTime && DateConvertor.isDateLieBetweenRange(date, slots.getStartDate(), slots.getEndDate()) && checkBookingOfUser(user, slots)) {
                int bookingId = uniqueId.createId() ;
                Booking createBooking = new Booking(bookingId, slots, centre, date) ;
                user.addBookingList(createBooking);
                System.out.println("booking successful");
                return createBooking ;
            }
        }

        System.out.println("no slots available");
        return null ;

    }

    boolean checkBookingOfUser(User user, Slots slots) {
        for (Booking booking : user.getBookingList()) {
            if (booking.getSlots().getId() == slots.getId()) {
                return false;
            }
        }
        return true;
    }
}
