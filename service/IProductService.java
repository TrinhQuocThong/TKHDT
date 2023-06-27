package service;

import MilkTeaStore.Beverage;
import MilkTeaStore.Topping;

import java.util.List;

public interface IProductService {
    public abstract double getTotalPrice(Beverage beverage, String flavour, List<Topping> toppingList, String size);
    public abstract Beverage setBeverage(String name);
    public abstract Topping createTopping(String name, int quantity);
}