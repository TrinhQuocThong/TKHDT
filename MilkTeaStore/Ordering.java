package MilkTeaStore;

import java.sql.Date;
import java.util.List;

public class Ordering implements IServiceObserver{
    private String cusId;
    private List<Beverage> drinks;
    private IPayStrategy pay;
    private String table;

    private Date date;
    private OrderData orderData;

    public Ordering(OrderData orderData) {
        super();
        this.orderData = orderData;
        orderData.registerServer(this);
    }

    @Override
    public void update(String cusId, List<Beverage> drinks, String table) {
        // TODO Auto-generated method stub

    }



    ///

    public void setPay (IPayStrategy ipay){
        pay = ipay;
    }

    ////



    public String getCusId() {
        return cusId;
    }

    public List<Beverage> getDrinks() {
        return drinks;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public String getTable(){ return table;}

    //chuyển đơn hàng lên orderData
    public void setOrderData(String cusId, List<Beverage> beverages, String table) {
        orderData.setCusId(cusId);
        orderData.setBeverages(beverages);
//		orderData.setAddress(table);

        //kêu cái orderData thông báo cho mấy cái service
        orderData.orderChanged();
    }


}