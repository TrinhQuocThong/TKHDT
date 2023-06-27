package MilkTeaStore;

import java.util.ArrayList;

public class Coffee extends Beverage{
    //	private double price=15000;
    private boolean isIce;
    public Coffee() {

        // TODO Auto-generated constructor stub
    }

    public Coffee( IFlavourStrategy flavour, ISizeStrategy size) {
        super(6000, flavour, size);
    }

    @Override
    public String getDescription() {
        return " Coffe ";
    }







    public void setIce(boolean ice) {
        isIce = ice;
    }

    public boolean getIsIce() {
        return isIce;
    }


}