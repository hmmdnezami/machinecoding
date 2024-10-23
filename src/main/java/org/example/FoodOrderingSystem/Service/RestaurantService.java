package org.example.FoodOrderingSystem.Service;


import org.example.FoodOrderingSystem.Entity.MenuItem;
import org.example.FoodOrderingSystem.Entity.Restaurant;
import org.example.FoodOrderingSystem.Exceptions.notFountException;
import org.example.FoodOrderingSystem.Helpers.Logger;
import org.example.FoodOrderingSystem.Interface.IRestaurantService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService implements IRestaurantService {
    private Map<String, Restaurant> nameToRestaurant = new HashMap<>();

    @Override
    public void addRestaurant(String name, double rating, int maxOrders, List<MenuItem> menu) {
        try {
            if (nameToRestaurant.containsKey(name)) {
                System.out.printf("Restaurant by Name : %s already exists!%n", name);
                return;
            }
            Logger.log("Adding Restaurant : " + name);
            nameToRestaurant.put(name, new Restaurant(name, rating, maxOrders, menu));
            System.out.println("Restaurant Added!");
        } catch (Exception ex) {
            Logger.log("Unknown Exception : " + ex.getMessage());
        }
    }

    @Override
    public void updateMenuItem(String restaurantName, MenuItem item) {
        try {
            if (!nameToRestaurant.containsKey(restaurantName)) {
                throw  new notFountException("Restaurant by Name : {} doesn't exist!%n");
//                System.out.printf("Restaurant by Name : %s doesn't exist!%n", restaurantName);
//                return;
            }
            Restaurant rest = nameToRestaurant.get(restaurantName);
            MenuItem existingItem = rest.getMenu().stream()
                    .filter(menuItem -> menuItem.getItemName().equals(item.getItemName()))
                    .findFirst()
                    .orElse(null);

            if (existingItem == null) {
                System.out.printf("Restaurant by Name : %s doesn't contain the supplied MenuItem!%n", restaurantName);
                return;
            }

            existingItem.setPrice(item.getPrice());
            Logger.log(String.format("Price of Menu Item %s in Restaurant %s updated to %s",
                    item.getItemName(), restaurantName, item.getPrice()));
        } catch (Exception ex) {
            Logger.log("Unknown Exception : " + ex.getMessage());
        }
    }

    @Override
    public void addMenuItem(String restaurantName, MenuItem item) {
        try {
            if (!nameToRestaurant.containsKey(restaurantName)) {
                System.out.printf("Restaurant by Name : %s doesn't exist!%n", restaurantName);
                return;
            }
            Restaurant rest = nameToRestaurant.get(restaurantName);
            if (rest.getMenu().contains(item)) {
                System.out.printf("Restaurant by Name : %s already contains the supplied MenuItem!%n", restaurantName);
                return;
            }

            rest.getMenu().add(item);
            Logger.log(String.format("Price of Menu Item %s in Restaurant %s updated to %s",
                    item.getItemName(), restaurantName, item.getPrice()));
        } catch (Exception ex) {
            Logger.log("Unknown Exception : " + ex.getMessage());
        }
    }


    public List<Restaurant> getRestaurant() {
        return new ArrayList<>(nameToRestaurant.values());
    }
}
