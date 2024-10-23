package org.example.gymBooking.helpers;

public class UniqueId {
    private  static  int count = 0 ;

    public int createId() {
        return this.count ++;
    }
}
