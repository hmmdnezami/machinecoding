package org.example.FoodOrderingSystem.Interface;


import org.example.FoodOrderingSystem.Entity.MenuItem;

import java.util.List;

public interface IRestaurantService {
    void addRestaurant(String name, double rating, int maxOrders, List<MenuItem> menu);
    void updateMenuItem(String restaurantName, MenuItem item);
    void addMenuItem(String restaurantName, MenuItem item);
}
