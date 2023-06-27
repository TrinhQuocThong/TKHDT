package MilkTeaStore;

public class Pudding extends Topping {

    private double price = 5000;

    public Pudding() {

    }

//    public Pudding(int quantity) {
//        super(price,quantity);
//
//    }

    public Pudding( int quantity) {
        super(quantity);
    }

    @Override
    public String getDiscription() {
        // TODO Auto-generated method stub
        return " Eggpudding ";
    }

    @Override
    public double getPrice() {

        return price*getQuantity();
    }



}