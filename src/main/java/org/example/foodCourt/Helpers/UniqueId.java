package org.example.foodCourt.Helpers;

public class UniqueId {

    public static int count =0 ;

    public int getId() {
        return count ++ ;
    }
}
