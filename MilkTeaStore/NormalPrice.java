package MilkTeaStore;

public class NormalPrice implements IPriceStrategy{



    @Override
    public int getPoint(double price) {
        // TODO Auto-generated method stub

        return Price.getPoint(this,price);
    }

    @Override
    public double getPrice(double price) {
        // TODO Auto-generated method stub
        return Price.getPrice(this,price);
    }


}