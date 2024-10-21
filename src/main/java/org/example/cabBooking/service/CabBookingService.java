package org.example.cabBooking.service;

import org.example.cabBooking.models.Driver;
import org.example.cabBooking.models.Location;
import org.example.cabBooking.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabBookingService {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Driver> drivers = new HashMap<>();
    private Map<String, Double> rideBills = new HashMap<>();

    // Onboard a new user
    public void addUser(String name, String gender, int age, Location location) {
        users.put(name, new User(name, gender, age, location));
    }

    // Update user's location
    public void updateUserLocation(String username, Location location) {
        if (users.containsKey(username)) {
            users.get(username).setLocation(location);
        }
    }

    // Onboard a new driver
    public void addDriver(String name, String vehicle, Location location) {
        drivers.put(name, new Driver(name, vehicle, location));
    }

    // Update driver's location
    public void updateDriverLocation(String driverName, Location location) {
        if (drivers.containsKey(driverName)) {
            drivers.get(driverName).setLocation(location);
        }
    }

    // Change driver status
    public void changeDriverStatus(String driverName, boolean status) {
        if (drivers.containsKey(driverName)) {
            drivers.get(driverName).setAvailable(status);
        }
    }

    // Find ride for a user based on proximity
    public List<Driver> findRide(String username, Location source, Location destination) {
        List<Driver> availableDrivers = new ArrayList<>();
        if (users.containsKey(username)) {
            for (Driver driver : drivers.values()) {
                if (driver.isAvailable() && driver.getLocation().calculateDistance(source) <= 5) {
                    availableDrivers.add(driver);
                }
            }
        }
        return availableDrivers;
    }

    // Choose a ride
    public String chooseRide(String username, String driverName, Location destination) {
        if (drivers.containsKey(driverName)) {
            Driver driver = drivers.get(driverName);
            if (driver.isAvailable()) {
                double bill = calculateBill(users.get(username).getLocation(), destination);
                rideBills.put(username, bill);
                driver.updateEarnings(bill);
                // Update driver and user locations
                updateUserLocation(username, destination);
                updateDriverLocation(driverName, destination);
                driver.setAvailable(false);  // Mark driver as unavailable
                return "Ride started with " + driverName + ". Bill: $" + bill;
            }
        }
        return "Ride couldn't be started";
    }

    // Calculate ride bill
    public double calculateBill(Location source, Location destination) {
        return source.calculateDistance(destination);
    }

    // Calculate total earnings for all drivers
    public Map<String, Double> findTotalEarnings() {
        Map<String, Double> driverEarnings = new HashMap<>();
        for (Driver driver : drivers.values()) {
            driverEarnings.put(driver.getName(), driver.getEarnings());
        }
        return driverEarnings;
    }
}