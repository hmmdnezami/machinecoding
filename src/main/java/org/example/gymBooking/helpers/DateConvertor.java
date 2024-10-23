package org.example.gymBooking.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConvertor {


    public static LocalDate getDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(date, formatter) ;
    }

    public static boolean isEqualDate(String date1, String date2) {
        return getDate(date1).equals(getDate(date2));
    }

    public static boolean isDateLieBetweenRange(String date, String startDate, String endDate) {
        if (getDate(date).isBefore(getDate(startDate))) return false;
        if (getDate(date).isAfter(getDate(endDate))) return  false;
        return true ;
    }
}
