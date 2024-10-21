package org.example.appointmentBooking.model;

import java.util.List;

public class Doctor {

    private String name ;
    private Speciality speciality;
    private List<Slots> slots;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Slots> getSlots() {
        return slots;
    }

    public void setSlots(List<Slots> slots) {
        this.slots = slots;
    }

    public Doctor() {
    }

    public Doctor(String name, Speciality speciality, List<Slots> slots) {
        this.name = name;
        this.speciality = speciality;
        this.slots = slots;
    }

    public void bookSlot(Slots slots) {
        slots.setAvailable(false);
    }

    public boolean isAvailable(Slots slot) {
        for (Slots sl : slots) {
            if (sl.equals(slot) && sl.isAvailable())  return true;
        }
        return false;
    }

    public void cancelAppointment(Slots slots) {
        slots.setAvailable(true);

    }
}
