package org.example.Restaurant.models;

import java.util.List;

public class Restaurant {

    private String name ;
    private List<Table> tables ;
    private MenuItems menu;
    private Kitchen kitchen;

    public String getName() {
        return name;
    }

    public List<Table> getTables() {
        return tables;
    }

    public MenuItems getMenu() {
        return menu;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public Restaurant(String name, List<Table> tables, MenuItems menu, Kitchen kitchen) {
        this.name = name;
        this.tables = tables;
        this.menu = menu;
        this.kitchen = kitchen;
    }
}
