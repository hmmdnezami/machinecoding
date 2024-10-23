package org.example.foodCourt;

import org.example.foodCourt.Service.OrderingService;
import org.example.foodCourt.Service.RestaurantServie;
import org.example.foodCourt.Service.UserService;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        RestaurantServie restaurantServie = RestaurantServie.getInstance();
        UserService userService =UserService.getInstance();
        OrderingService orderingService = OrderingService.getInstance();

        userService.registerUser("Nitesh", "M", "phone1", "HSR");
        userService.registerUser("Kamlesh", "M", "phone2", "Whitefield");
        userService.registerUser("Harish", "M", "phone3", "Hoody");

        List<String> pinCode= new ArrayList<>();
        pinCode.add("BTM") ;
        pinCode.add("HSR") ;
        restaurantServie.registerRestaurant("FoodCourt1", pinCode, "NIThali", 100, 5);
        pinCode.clear();
        List<String> pinCode2= new ArrayList<>();
        pinCode2.add("BTM") ;
        restaurantServie.registerRestaurant("FoodCourt2", pinCode2, "Burger", 150, 3);
        pinCode.clear();
        pinCode.add("HSR") ;
        restaurantServie.registerRestaurant("FoodCourt3", pinCode, "sIThali", 150, 1);


        boolean login = userService.logInUser("phone1");

        if (login) {

            restaurantServie.showAllRestaurantBasedOnFiltering("Rating", 0) ;
            orderingService.placeOrder("FoodCourt2", 2);

            orderingService.placeOrder("FoodCourt2", 7);

        }


    }
}
