package org.example.gymBooking.service;

import org.example.gymBooking.Interface.ICentreService;
import org.example.gymBooking.entity.Centre;
import org.example.gymBooking.entity.Slots;
import org.example.gymBooking.entity.WorkoutType;
import org.example.gymBooking.helpers.DateConvertor;
import org.example.gymBooking.helpers.UniqueId;
import org.example.gymBooking.helpers.WorkOutFactory;

import java.util.*;

public class CentreService implements ICentreService {

    private CentreService(){} ;

    private static CentreService instance = null ;

    public static CentreService getInstance() {
        if (instance == null) instance = new CentreService();
        return instance;
    }

    HashMap<String ,Centre> centres = new HashMap<>();


    private List<Centre> centreList = new ArrayList<>() ;

    private UniqueId uniqueId = new UniqueId();

    public void addCentre(String name, int maximumCapacity, WorkoutType workoutType, int startTime, int endTime, String startDate, String endDate) {

        List<Slots> slotsList = new ArrayList<>();
        int slotId = uniqueId.createId();
        Slots slots = new Slots(slotId, maximumCapacity, workoutType, startTime, endTime, startDate, endDate) ;
        if (!centres.containsKey(name)) {
            slotsList.add(slots);
            Centre centre = new Centre(name, slotsList);
            centreList.add(centre);
            centres.put(name, centre);
        }
        else {
            Centre centre = centres.get(name);
            centre.addSlot(slots);

        }
    }


    @Override
    public List<Slots> viewWorkoutAvailability(String workOut, String date) {
        List<Slots> availableSlots = new ArrayList<>();

        WorkoutType workoutType = WorkOutFactory.createWorkoutType(workOut) ;
        for (Centre centre : centreList) {
            for (Slots slots : centre.getSlots()) {
                if (slots.getWorkoutType().equals(workoutType) && checkDateRange(date, slots.getDate(), slots.getEndDate())) {
                    availableSlots.add(slots);
                }
            }
        }

        return availableSlots;
    }


    boolean checkDateRange(String date, String startDate, String endDate) {
        return DateConvertor.isDateLieBetweenRange(date, startDate, endDate);
    }


    public Centre getCentre(String workoutLocation) {
        if (!centres.containsKey(workoutLocation)) return null;
        return centres.get(workoutLocation);
    }

    public void addWorkoutToCentre(String name, String weightType, int startTime, int endTime, int capacity, String startDate, String endDate) {

        if (!centres.containsKey(name)) {
            System.out.println("no cnetre available");
        }

        int slotId = uniqueId.createId();
        WorkoutType workoutType = WorkOutFactory.createWorkoutType(weightType);
        Slots slots = new Slots(slotId, capacity, workoutType, startTime, endTime, startDate, endDate) ;
        Centre centre = centres.get(name);
        centre.addSlot(slots);

        System.out.println("Slot added successfully");
        return ;

    }
}
