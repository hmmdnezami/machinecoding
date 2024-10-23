package org.example.foodCourt.Interface;

public interface IUserService {

    public int registerUser(String name, String gender, String phoneNumber, String location);


    public boolean logInUser(String phoneNumber) ;
}
