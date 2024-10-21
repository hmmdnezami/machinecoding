package org.example.appointmentBooking.model;

public class Cardiologist  extends Speciality{
    @Override
    public void work() {
        System.out.println("cardiologist.... ");


    }

    @Override
    public boolean equals(Object obj) {
        // Check if the object is the same instance or belongs to the same class
        return obj instanceof Cardiologist;
    }

    @Override
    public int hashCode() {
        // All Cardiologists should have the same hash code, as they represent the same specialty
        return "Cardiologist".hashCode();
    }
}
