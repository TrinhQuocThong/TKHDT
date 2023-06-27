package MilkTeaStore;

import java.util.List;

public class WaiterService implements IServiceObserver{
    private OrderData orderData;
    private String table;

    public WaiterService(OrderData orderData, String table) {
        super();
        this.orderData = orderData;
        this.table = table;
    }

    @Override
    public void update(String cusId, List<Beverage> drinks, String table) {
        // TODO Auto-generated method stub
        this.table=table;
        this.DeliveryDrink();
    }

    public void DeliveryDrink(){
//		Systemp.out.println("Ban " + this.table + " da duoc giao nuoc");
    }

}