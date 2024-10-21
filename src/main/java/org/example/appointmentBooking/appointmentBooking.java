package org.example.appointmentBooking;

import org.example.appointmentBooking.model.Cardiologist;
import org.example.appointmentBooking.model.Doctor;
import org.example.appointmentBooking.model.Slots;
import org.example.appointmentBooking.service.appointmentService;

import java.util.ArrayList;
import java.util.List;

public class appointmentBooking {
    public static void main(String[] args) {
        appointmentService AppointMent = new appointmentService();
        List<Slots> slotsList = new ArrayList<>();
        slotsList.add(new Slots(9.0, 9.30));
        slotsList.add(new Slots(10.0, 10.30));
        AppointMent.onboardDoctor("Dr Isha", new Cardiologist(), slotsList);
        List<Doctor> doctorList = AppointMent.findAllAvailableDoctorBasedOnSpeciality(new Cardiologist());
        for (Doctor doctor : doctorList) {
            System.out.println(doctor.getName() );
            for (Slots s : doctor.getSlots()) System.out.println(s.getStartTime() + " " + s.getEndTime());
        }
//        AppointMent.onboardDoctor("XYZ", new Cardiologist(), new ArrayList<> {new Slots(9.00, 9.30)}) ;
    }
}
