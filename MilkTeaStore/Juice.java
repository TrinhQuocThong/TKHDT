package MilkTeaStore;

import java.util.ArrayList;

public class Juice extends Beverage {


    public Juice() {
    }

    public Juice(IFlavourStrategy flavour, ISizeStrategy size) {
        super(7000, flavour, size);
    }

    @Override
    public String getDescription() {
        return "Juice";
    }





}