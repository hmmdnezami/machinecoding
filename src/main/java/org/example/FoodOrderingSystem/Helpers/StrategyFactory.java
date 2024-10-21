package org.example.FoodOrderingSystem.Helpers;


import org.example.FoodOrderingSystem.Interface.IStrategy;
import org.example.FoodOrderingSystem.Service.LowestPriceStrategy;

public class StrategyFactory {

    public static IStrategy getStrategy(String strategyName) {
        switch (strategyName) {
            case "LowestPrice":
                return new LowestPriceStrategy();
            default:
                System.out.println("Strategy Not Found!");
                return new LowestPriceStrategy();
        }
    }
}
