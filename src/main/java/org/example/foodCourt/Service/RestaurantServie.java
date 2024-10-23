package org.example.foodCourt.Service;

import org.example.foodCourt.Helpers.FilteringFactory;
import org.example.foodCourt.Helpers.UniqueId;
import org.example.foodCourt.Interface.IFiltering;
import org.example.foodCourt.Interface.IRestaurantService;
import org.example.foodCourt.entity.FoodItem;
import org.example.foodCourt.entity.Restaurant;
import org.example.foodCourt.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestaurantServie implements IRestaurantService {

    private RestaurantServie() {};

    private static RestaurantServie instance ;
    public static RestaurantServie getInstance() {
        if (instance == null) instance = new RestaurantServie();
        return instance;
    }
    List<Restaurant> restaurants = new ArrayList<>();


    HashMap<String , Restaurant> restaurantList = new HashMap<>();

    private UniqueId uniqueId = new UniqueId();

    private UserService userService = UserService.getInstance();

    @Override
    public int registerRestaurant(String name, List<String> pinCodes, String foodName, double price, int quantity) {
        if (restaurantList.containsKey(name)) {
            System.out.println("already registered");
            return -1 ;
        }

        FoodItem foodItem = new FoodItem(foodName, price, quantity) ;

        int restaurantId =  uniqueId.getId();
        Restaurant restaurant = new Restaurant(restaurantId, name, pinCodes, foodItem) ;
        restaurantList.put(name, restaurant) ;
        restaurants.add(restaurant);
        return restaurantId;

    }

    @Override
    public boolean updateQuantity(String name, int quantityToAdd) {
        if (!restaurantList.containsKey(name)) {
            System.out.println("no restaurant exist");
            return  false;
        }

        Restaurant restaurant = restaurantList.get(name) ;
        restaurant.getFoodItem().addQuantity(quantityToAdd);
        System.out.println("Quantity added succesfully");
        return true;
    }

    @Override
    public List<Restaurant> showAllRestaurantBasedOnFiltering(String condition, int userId) {

        IFiltering filtering = FilteringFactory.getInstance(condition) ;
        List<Restaurant> restaurantList1=  filtering.filterRestaurant(userId);
        for (Restaurant restaurant : restaurantList1){
            System.out.println(restaurant.getName() +" " +restaurant.getFoodItem().getFoodName());
        }

        return restaurantList1;

    }

    public List<Restaurant> getAllRestaurant(int userId) {

        User user = userService.getUser(userId) ;

        List<Restaurant> allRestaurant = new ArrayList<>();

        for (Restaurant restaurant : this.restaurants) {
            for (String pin : restaurant.getPinCode()) {
                if (pin.equals(user.getLocation())) {
                    allRestaurant.add(restaurant);
                    break;
                }
            }
        }


        return allRestaurant;
    }

    public Restaurant hasRestaurant(String name) {
        if ( !restaurantList.containsKey(name) ) return null;
        return restaurantList.get(name) ;
    }
}
