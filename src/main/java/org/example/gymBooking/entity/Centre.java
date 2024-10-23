package org.example.gymBooking.entity;

import java.util.ArrayList;
import java.util.List;

public class Centre {

    private int id ;
    private String name ;
    private List<Slots> slots ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Slots> getSlots() {
        return slots;
    }

    public void setSlots(List<Slots> slots) {
        this.slots = slots;
    }

    public Centre(String name, List<Slots> slots) {
        this.name = name;
        this.slots = slots;
    }

    public void addSlot(Slots slot) {
        this.slots.add(slot);
    }
}
