package MilkTeaStore;

public class SalePrice implements IPriceStrategy{
    //có thể sửa đổi phần trăm
    private int salingPercent=30;

    @Override
    public double getPrice(double price) {
        // TODO Auto-generated method stub
        return Price.getPrice(this,price);
    }

    @Override
    public int getPoint(double price) {
        // TODO Auto-generated method stub
        return Price.getPoint(this,price);
    }


}