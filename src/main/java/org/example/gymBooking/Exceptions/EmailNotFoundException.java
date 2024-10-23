package org.example.gymBooking.Exceptions;

public class EmailNotFoundException extends Exception{

    public EmailNotFoundException(String message){
        super(message);
        System.out.println(message);
    }
}
