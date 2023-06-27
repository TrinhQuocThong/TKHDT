package MilkTeaStore;

public class SoftDrink extends Beverage{

    public SoftDrink() {

        // TODO Auto-generated constructor stub
    }

    public SoftDrink(IFlavourStrategy flavour, ISizeStrategy size) {
        super(3000, flavour, size);
    }

    @Override
    public String getDescription() {
        return "SoftDrink";
    }





}