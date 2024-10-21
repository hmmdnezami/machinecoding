package org.example.appointmentBooking.service;

import org.example.appointmentBooking.model.Doctor;
import org.example.appointmentBooking.model.Patient;
import org.example.appointmentBooking.model.Slots;
import org.example.appointmentBooking.model.Speciality;

import java.sql.SQLOutput;
import java.util.*;

public class appointmentService {

    HashMap<Speciality, List<String>> specialityDoctor ;
    HashMap<String, Doctor> doctors ;
    HashMap<String, Patient> patients;
    HashMap<String, Queue<String>> waitingList;

    public appointmentService() {
        specialityDoctor = new HashMap<>() ;
        doctors = new HashMap<>() ;
        patients = new HashMap<>() ;
        waitingList = new HashMap<>();
    }



    //add doctor to application
    public String  onboardDoctor(String name, Speciality speciality, List<Slots> slots) {
        if (!specialityDoctor.containsKey(speciality)) specialityDoctor.put(speciality, new ArrayList<>()) ;
        specialityDoctor.get(speciality).add(name);
        doctors.put(name, new Doctor(name, speciality, slots)) ;
        System.out.println(specialityDoctor.size());
        System.out.println("doctor onboarded successfully !!");
        return "doctor onboarded successfully !!";
    }

    public String updateDoctorProfie (Slots slots, String name) {
        if (doctors.containsKey(name)) {
            doctors.get(name).getSlots().add(slots);
            return "slot added successfully" ;
        }
        return "No doctor available with name : "+ name;
    }


    public String onboardPatient(String name){
        patients.put(name, new Patient(name)) ;
        return "Patient added successfully !!";
    }

    public List<Doctor> findAllAvailableDoctorBasedOnSpeciality(Speciality speciality) {
        if (!specialityDoctor.containsKey(speciality)) {
            System.out.println("No doctor available.. ");
            return new ArrayList<>();
        }
        List<Doctor> availableDoctor = new ArrayList<>() ;

        for (String doctor: specialityDoctor.get(speciality)) {
             availableDoctor.add(doctors.get(doctor));
        }
        return availableDoctor;
    }

    public String bookDoctorBasedOnSlot(String patient, String doctor, Slots slots) {
        if (!patients.containsKey(patient)) return "Please register first.." ;
        if (patients.get(patient).patientBooking(slots)) return "Patient has already booking... " ;
        if (!doctors.get(doctor).isAvailable(slots))  return "please select some other slots";
        doctors.get(doctor).bookSlot(slots);
        patients.get(patient).addBooking(slots);
        return "booking confirmed" ;
    }

    public String cancelBooking(String patient , String doctor, Slots slots) {
        if (!patients.get(patient).patientBooking(slots)) return "No booking available" ;
        patients.get(patient).cancelBooking(slots);
        doctors.get(doctor).cancelAppointment(slots);
        if (waitingList.containsKey(doctor))  notifyAllPatient(doctor, slots);
        return "appointment cancelled succesfully.. !!";
    }

    public void notifyMeWhenDoctorIsAvailable(String user, String doctor) {
        if (!waitingList.containsKey(doctor)) waitingList.put(doctor, new LinkedList<>()) ;
        waitingList.get(doctor).add(user);
        return ;
    }

    public void notifyAllPatient(String doctor, Slots slots) {
        while (!waitingList.get(doctor).isEmpty() ) {
            System.out.println("doctor is available for this slot" + slots.getStartTime());
            waitingList.get(doctor).remove();
        }

    }




}


