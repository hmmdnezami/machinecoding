package org.example.cabBooking;

import org.example.cabBooking.models.Location;
import org.example.cabBooking.service.CabBookingService;

public class cabBookingApplication {
    public static void main(String[] args) {
        CabBookingService service = new CabBookingService();

        // Onboarding users
        service.addUser("Abhishek", "M", 23, new Location(0, 0));
        service.addUser("Rahul", "M", 29, new Location(10, 0));
        service.addUser("Nandini", "F", 22, new Location(15, 6));

        // Onboarding drivers
        service.addDriver("Driver1", "Swift, KA-01-12345", new Location(10, 1));
        service.addDriver("Driver2", "Swift, KA-01-12345", new Location(11, 10));
        service.addDriver("Driver3", "Swift, KA-01-12345", new Location(5, 3));

        // User Abhishek trying to find a ride
        System.out.println(service.findRide("Abhishek", new Location(0, 0), new Location(20, 1)));

        // User Rahul trying to find and choose a ride
        System.out.println(service.findRide("Rahul", new Location(10, 0), new Location(15, 3)));
        System.out.println(service.chooseRide("Rahul", "Driver1", new Location(15, 3)));

        // Calculate earnings
        System.out.println(service.findTotalEarnings());
    }
}
