package org.example.gymBooking.Interface;

import org.example.gymBooking.entity.Booking;

public interface IBookingService {

    public Booking bookSession(String email, String workoutLocation, String workoutType, int startTime, int endTime, String date)  ;
}
