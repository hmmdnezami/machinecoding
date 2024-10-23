package org.example.gymBooking.entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id ;

    private String name ;
    private String email;
    private String location ;
    private List<Booking> bookingList = new ArrayList<>();

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void addBookingList(Booking booking) {
        this.bookingList.add(booking);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public User(int id, String name, String email, String location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
        this.bookingList = new ArrayList<>();
    }
}
