package org.example.foodCourt.Service;

import org.example.foodCourt.Interface.IFiltering;
import org.example.foodCourt.entity.Restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FilteringBasedOnRating implements IFiltering {

    private RestaurantServie restaurantServie = RestaurantServie.getInstance();

    private List<Restaurant> restaurants = new ArrayList<>();

    @Override
    public List<Restaurant> filterRestaurant(int userId) {

        List <Restaurant> allRestaurants = restaurantServie.getAllRestaurant(userId);
        Collections.sort(allRestaurants, (a, b) -> Double.compare(b.getRating() , a.getRating()));
        return allRestaurants;
    }
}
