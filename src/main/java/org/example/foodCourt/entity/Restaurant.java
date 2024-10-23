package org.example.foodCourt.entity;

import java.util.List;

public class Restaurant {

    private int id ;

    private String name ;
    private List<String> pinCode;
    private FoodItem foodItem;
    private double rating ;
    private String comments;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPinCode() {
        return pinCode;
    }

    public void setPinCode(List<String> pinCode) {
        this.pinCode = pinCode;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Restaurant(int id, String name, List<String> pinCode, FoodItem foodItem) {
        this.id = id;
        this.name = name;
        this.pinCode = pinCode;
        this.foodItem = foodItem;
    }
}
