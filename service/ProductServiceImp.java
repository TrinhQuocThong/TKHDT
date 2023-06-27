package service;

import MilkTeaStore.*;

import java.util.List;

public class ProductServiceImp implements  IProductService{
    ToppingFactory toppingFactory = new ToppingFactory();
    @Override
    public double getTotalPrice(Beverage beverage, String flavour, List<Topping> toppingList, String size) {
        beverage.setFlavour(flavour);
        beverage.setSize(size);
        for(Topping topping: toppingList){
            beverage.addTopping(topping);
        }
        return beverage.getTotalPrice();
    }

    @Override
    public Beverage setBeverage(String name) {
        Beverage beverage ;
        if(name.equalsIgnoreCase("Milktea")){
            beverage = new MilkTea();
            return beverage;
        }
        else if(name.equalsIgnoreCase("Coffee")){
            beverage = new Coffee();
            return beverage;

        }
        else if(name.equalsIgnoreCase("Juice")){
            beverage = new Juice();
            return beverage;

        }
        else if(name.equalsIgnoreCase("SoftDrink")){
            beverage = new SoftDrink();
            return beverage;

        }
//        else{
//            beverage = null;
//        }
        return null;
    }

    @Override
    public Topping createTopping(String name, int quantity) {
        return toppingFactory.createTopping(name, quantity);
    }
}