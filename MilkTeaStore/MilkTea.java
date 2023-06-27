package MilkTeaStore;

public class MilkTea extends Beverage{
    //	private double price= 13000;
    public MilkTea() {

    }

    public MilkTea( IFlavourStrategy flavour, ISizeStrategy size) {
        super(5000, flavour, size);
    }

    @Override
    public String getDescription() {
        return "MilkTea";
    }












}