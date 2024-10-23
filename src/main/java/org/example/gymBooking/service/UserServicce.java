package org.example.gymBooking.service;

import org.example.gymBooking.Exceptions.EmailNotFoundException;
import org.example.gymBooking.Interface.IUserService;
import org.example.gymBooking.entity.Booking;
import org.example.gymBooking.entity.User;
import org.example.gymBooking.helpers.DateConvertor;
import org.example.gymBooking.helpers.UniqueId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserServicce implements IUserService {

    private UserServicce(){} ;

    private static UserServicce instance = null ;

    public static UserServicce getInstance() {
        if (instance == null) instance = new UserServicce();
        return instance;
    }

    private UniqueId uniqueId = new UniqueId();

    private HashMap<String, User> users = new HashMap<>() ;

    @Override
    public int registerUser(String name, String email, String location) {
        if (users.containsKey(email)) {
            System.out.println("user already exist");
            return -1;
        }

        int userId = uniqueId.createId();
        User user = new User(userId, name, email, location) ;
        users.put(email, user);
        System.out.println("user created with id " + userId);
        return userId;

    }

    @Override
    public List<Booking> viewSchedule(String email, String date) throws EmailNotFoundException {

        if (!users.containsKey(email)) {
            System.out.println("email not found");
            return null;
        }

        User user = users.get(email) ;
        List<Booking> bookings= new ArrayList<>();
        for (Booking booking : user.getBookingList()) {
            if (DateConvertor.isEqualDate(date, booking.getDate())) {
                bookings.add(booking);
            }
        }
        return bookings ;
    }

    public User checkUser(int userId) {
        return null ;
    }

    public User getUser(String email) {
        if (!users.containsKey(email)) return null ;
        return users.get(email);

    }
}
