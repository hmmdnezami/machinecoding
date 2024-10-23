package org.example.foodCourt.Helpers;

import org.example.foodCourt.Interface.IFiltering;
import org.example.foodCourt.Service.FilteringBasedOnPrice;
import org.example.foodCourt.Service.FilteringBasedOnRating;

public class FilteringFactory {

    public static IFiltering getInstance(String filter) {
        switch (filter){
            case "Rating" :
                return new FilteringBasedOnRating();
            case "Price" :
                return new FilteringBasedOnPrice();
            default:
                return new FilteringBasedOnPrice();
        }

    }
}
