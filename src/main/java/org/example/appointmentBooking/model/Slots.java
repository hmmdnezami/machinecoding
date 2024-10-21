package org.example.appointmentBooking.model;

import java.sql.Time;

public class Slots {

    private double startTime;
    private double endTime ;
    private boolean isAvailable;


    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Slots(double startTime, double endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isAvailable = true;
    }
}
