package MilkTeaStore;

public class CardPay implements IPayStrategy{

    private double extraFee= 0.04;
    @Override
    public double pay(double totalPay) {
        // TODO Auto-generated method stub
        return totalPay + totalPay*extraFee;
    }



}