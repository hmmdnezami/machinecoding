package org.example.gymBooking.helpers;

import org.example.gymBooking.entity.Cardio;
import org.example.gymBooking.entity.Weights;
import org.example.gymBooking.entity.WorkoutType;

public class WorkOutFactory {

    public static WorkoutType createWorkoutType(String work) {
        switch (work) {
            case "Cardio" :
                return new Cardio();
            case "Weights" :
                return new Weights();
            default:
                return new Cardio();
        }
    }
}
