package org.example.gymBooking.Interface;

import org.example.gymBooking.entity.Centre;
import org.example.gymBooking.entity.Slots;

import java.util.List;

public interface ICentreService {

    public List<Slots> viewWorkoutAvailability(String workOut, String date) ;
}
