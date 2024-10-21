package org.example.cabBooking.service;

import org.example.cabBooking.models.Driver;
import org.example.cabBooking.models.Location;
import org.example.cabBooking.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cabBooking {

    private HashMap<String, User> users;
    private HashMap<String, Driver> drivers ;

    cabBooking() {
        users = new HashMap<>();
        drivers = new HashMap<>();
    }

    // add user with proper user details
    public void addUser(String name, String gender, int age, Location location) {
        users.put(name, new User(name, gender, age, location));
    }

    // update user location
    public void updateUserLocation(String name, Location location) {
        if (users.containsKey(name)) {
            users.get(name).setLocation(location);
        }
    }

    // onboard driver to application
    public void addDriver(String name, String vehicle, Location location) {
        drivers.put(name, new Driver(name, vehicle, location));
    }

    // updateDriver LLocation
    public void updateDriverLocation(String name, Location location) {
        if (drivers.containsKey(name)) {
            drivers.get(name).setLocation(location);
        }
    }

    public boolean distanceBetweenSourceAndDestination(Location dest, Location source) {
        return (Math.sqrt(dest.getX()*dest.getX() + dest.getY()*dest.getY() ) <= 5) ;
    }

    public List<Driver> findRide(String name ,  Location userLocation) {
        List<Driver> availableDriver = new ArrayList<>();
        if (users.containsKey(name)) {
            for (Driver driver : drivers.values()) {
                if (driver.isAvailable() && distanceBetweenSourceAndDestination(driver.getLocation(), userLocation)) {
                    availableDriver.add(driver);
                }
            }
        }
        return availableDriver;
    }



}
