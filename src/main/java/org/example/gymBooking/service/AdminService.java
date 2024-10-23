package org.example.gymBooking.service;

import org.example.gymBooking.Interface.IAdminService;

public class AdminService implements IAdminService {

    private CentreService centreService = CentreService.getInstance();

    @Override
    public void addWorkout(String name, String weightType, int startTime, int endTime, int capacity, String startDate, String endDate) {
        centreService.addWorkoutToCentre(name, weightType, startTime, endTime, capacity, startDate, endDate);
    }
}
