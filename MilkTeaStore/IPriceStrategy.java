package MilkTeaStore;

public interface IPriceStrategy {
    public double getPrice(double price);
    public int getPoint(double price);
}