package org.example.gymBooking.Interface;

import org.example.gymBooking.Exceptions.EmailNotFoundException;
import org.example.gymBooking.entity.Booking;

import java.util.List;

public interface IUserService {


    public int registerUser(String name, String email, String location) ;
    public List<Booking> viewSchedule(String email, String date) throws EmailNotFoundException;

}
