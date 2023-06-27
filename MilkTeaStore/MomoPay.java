package MilkTeaStore;

public class MomoPay implements IPayStrategy{

    private double extraFee= 0;
    @Override
    public double pay(double totalPay) {
        // TODO Auto-generated method stub
        return totalPay + totalPay*extraFee;
    }

}