package org.example.foodCourt.Service;

import org.example.foodCourt.Helpers.UniqueId;
import org.example.foodCourt.Interface.IUserService;
import org.example.foodCourt.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserService implements IUserService {

    private UserService() {};

    private static UserService instance ;
    public static UserService getInstance() {
        if (instance == null) instance = new UserService();
        return instance;
    }


    UniqueId uniqueId = new UniqueId();

    HashMap<String, User> userList = new HashMap<>();
    List<User> users = new ArrayList<>();

    public  User getUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) return user;
        }
        return null ;
    }

    @Override
    public int registerUser(String name, String gender, String phoneNumber, String location) {

        if (userList.containsKey(phoneNumber)) {
            System.out.println("user already registered");
            return -1 ;
        }

        int userId = uniqueId.getId();
        User user = new User(userId, name, gender, phoneNumber, location) ;
        userList.put(phoneNumber, user);
        users.add(user) ;
        System.out.println("user registered with id " +  userId);
        return userId;

    }

    @Override
    public boolean logInUser(String phoneNumber) {
        if (!userList.containsKey(phoneNumber)) {
            System.out.println("registered first");
            return false ;
        }
        System.out.println("login successfully");
        return  true;
    }


}
