package org.example.FoodOrderingSystem.Exceptions;

public class NotFountException extends Exception{

    public NotFountException(String mes) {
        super(mes);
        System.out.println(mes);
    }
}
