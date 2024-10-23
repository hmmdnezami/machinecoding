package org.example.gymBooking.entity;

public class Slots {

    private int id ;
    private int maximumCapacity ;
    private WorkoutType workoutType;
    private int startTime ;
    private int endTime ;
    private String startDate ;
    private String endDate;
    private int totalBooking ;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDate() {
        return startDate;
    }

    public void setDate(String date) {
        this.startDate = date;
    }

    public int getTotalBooking() {
        return totalBooking;
    }

    public void setTotalBooking() {
        this.totalBooking += 1 ;
    }

    public Slots(int id, int maximumCapacity, WorkoutType workoutType, int startTime, int endTime, String startDate, String endDate) {
        this.id = id ;
        this.maximumCapacity = maximumCapacity;
        this.workoutType = workoutType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalBooking = 0;
    }

    public boolean isAvailable() {
        return this.totalBooking < this.maximumCapacity;
    }
}
