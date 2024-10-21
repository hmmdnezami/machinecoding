package org.example.Restaurant.models;

public class MenuItems {

    private String name ;
    private Category category;
    private FoodType foodType ;
    private double price ;

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public double getPrice() {
        return price;
    }

    public MenuItems(String name, Category category, FoodType foodType, double price) {
        this.name = name;
        this.category = category;
        this.foodType = foodType;
        this.price = price;
    }
}
