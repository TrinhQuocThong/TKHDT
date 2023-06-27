package MilkTeaStore;

import java.util.List;

public class MailService implements IServiceObserver{
    private OrderData orderData;
    private String cusId;
    public MailService(OrderData orderData) {
        super();
        this.orderData = orderData;
        orderData.registerServer(this);
    }
    @Override
    public void update(String cusId, List<Beverage> drinks, String address) {
        // TODO Auto-generated method stub

    }



}