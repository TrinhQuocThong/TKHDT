package view;


// class này lấy địa chỉ của ORDER được tạo ở Home
public class Pointer {

    public static Order currentOrder;

    public  static Pay currentPay ;

    public static Watercounters currentWatercounters ;

    public static Watercounters setCurrentWatercounters(Watercounters a){

        return currentWatercounters =a ;
    }
    public static Order setCurrentOrder(Order order) {
        return Order.setCurrentOrder(order) ;
    }
//    public static Pay setCurrentPay(Pay pay) {
//        return Pay.setCurrentPay(pay);
//    }

}
