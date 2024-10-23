package org.example.FoodOrderingSystem.Exceptions;

public class notFountException extends Exception{

    public notFountException(String mes) {
        super(mes);
        System.out.println(mes);
    }
}
