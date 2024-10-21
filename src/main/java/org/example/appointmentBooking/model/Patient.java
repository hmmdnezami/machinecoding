package org.example.appointmentBooking.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Patient {

    private String name ;
    private HashMap <Slots, Boolean> slotsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public Patient(String name) {
        this.name = name;
        this.slotsList = new HashMap<>();
    }

    public boolean patientBooking(Slots slots) {
        return slotsList.containsKey(slots);
    }

    public void addBooking(Slots slots) {
        slotsList.put(slots, true);
    }

    public void cancelBooking(Slots slots) {
        slotsList.remove(slots) ;
    }
}
