package org.example.foodCourt.Interface;

import org.example.foodCourt.entity.Restaurant;

import java.util.List;

public interface IRestaurantService {

    public int registerRestaurant(String name, List<String> pinCodes, String foodName, double price, int quantity);

    public boolean updateQuantity(String name, int quantityToAdd) ;

    public List<Restaurant> showAllRestaurantBasedOnFiltering(String condition, int userId) ;

}
