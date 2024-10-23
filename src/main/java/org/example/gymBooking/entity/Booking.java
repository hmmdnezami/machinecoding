package org.example.gymBooking.entity;

import java.time.format.DateTimeFormatter;

public class Booking {

    private int id ;
    private Slots slots;
    private Centre centre;
    private String date ;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Slots getSlots() {
        return slots;
    }

    public void setSlots(Slots slots) {
        this.slots = slots;
    }

    public Centre getCentre() {
        return centre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public Booking(int id, Slots slots, Centre centre, String date) {
        this.id = id;
        this.slots = slots;
        this.centre = centre;
        this.date = date;
    }
}

//Booking ID, Slot information(Slot ID, Slot timing, workout type), Center information(Center ID, Center Name)