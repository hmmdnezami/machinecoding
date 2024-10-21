package org.example.cabBooking.models;

public class Driver {
    private String name;
    private String vehicle;
    private Location location;
    private boolean isAvailable;
    private double earnings;

    // Constructor, Getters, and Setters
    public Driver(String name, String vehicle, Location location) {
        this.name = name;
        this.vehicle = vehicle;
        this.location = location;
        this.isAvailable = true;
        this.earnings = 0;
    }

    public String getName() { return name; }
    public Location getLocation() { return location; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public void updateEarnings(double amount) { this.earnings += amount; }
    public double getEarnings() { return earnings; }
    public void setLocation(Location location) { this.location = location; }
}
