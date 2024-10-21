package org.example.Restaurant.service;

import org.example.Restaurant.models.MenuItems;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuService {

    private List<MenuItems> menuItems ;

    public MenuService(List<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }

    public void updateMenuList(MenuItems oldItems, MenuItems newItem) {
        int ind = menuItems.indexOf(oldItems) ;
        if (ind != -1) menuItems.set(ind, newItem) ;
    }

    public void removeMenuItem (MenuItems items) {
        menuItems.remove(items) ;
    }

    public List<MenuItems> searchItemBasedOnVegOrNonVeg(String category) {
        List<MenuItems> items = new ArrayList<>() ;
        for (MenuItems menuItems1 : menuItems) {
            if (category.equals(menuItems1.getFoodType().toString())) {
                items.add(menuItems1) ;
            }
        }
        return items;
    }

}
