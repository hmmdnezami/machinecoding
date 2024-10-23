package org.example.foodCourt.Interface;

import org.example.foodCourt.entity.Restaurant;

import java.util.List;

public interface IFiltering {
    List<Restaurant> filterRestaurant(int userId);
}
