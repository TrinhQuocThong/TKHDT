package MilkTeaStore;

import java.util.ArrayList;
import java.util.List;

public class PrepareOrderService implements IServiceObserver{
    private OrderData orderData;
    private List<Beverage> drinks= new ArrayList<>();

    public PrepareOrderService(OrderData orderData) {
        super();
        this.orderData = orderData;
        orderData.registerServer(this);

    }

    @Override
    public void update(String cusId, List<Beverage> drinks, String address) {
        // TODO Auto-generated method stub
        this.drinks= drinks;
        this.prepareOrder();

    }

    public void prepareOrder(){
        System.out.println("Don nuoc: " + this.drinks.toString() + " dang duoc thuc hien");
    }

}