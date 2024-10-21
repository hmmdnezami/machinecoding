package org.example.cabBooking.models;

public class User {
    private String name;
    private String gender;
    private int age;
    private Location location;

    // Constructor, Getters, and Setters
    public User(String name, String gender, int age, Location location) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.location = location;
    }

    public String getName() { return name; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}