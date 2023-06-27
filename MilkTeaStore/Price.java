package MilkTeaStore;

public class Price {

    public static double getPrice(Object object, double price) {
        if(object instanceof NormalPrice) {

            return price;
        }
        else if(object instanceof SalePrice) {
            return 0.8*price;
        }
        else if(object instanceof SpecialOccasionPrice ) {
            return 0.6*price;
        }
        return 0;
    }
    public static int getPoint(Object object, double price) {


        return (int) getPrice(object, price)/5000;

    }

}