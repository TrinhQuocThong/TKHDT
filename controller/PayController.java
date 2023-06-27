package controller;

import MilkTeaStore.Beverage;
import MilkTeaStore.IPayStrategy;
import view.Order;
import view.Pay;
import view.Pointer;
import view.Watercounters;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PayController implements ActionListener {


    private ArrayList<Beverage> list ;
    private Pay pay ;

private IPayStrategy ipay ;

    public PayController(Pay pay){


        this.pay = pay ;

    }
    public void setPay(IPayStrategy pay){

        ipay = pay ;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        //+cần dùng hàm thanh toán Pay để đưa giá này vào khi chọn vào cái gì đó (vì card , cash , online đều có hàm thanh toán
        //check xem nếu trường hợp nào thì hiển thị dúng theo trường hợp đó :

        if (pay.getDrinksTable().getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "giỏ hàng trống vui lòng thêm đồ uống !");
        } else if (!pay.getCashPayment().isSelected() && !pay.getCardPayment().isSelected() && !pay.getOnlinePayment().isSelected()) {
            JOptionPane.showMessageDialog(null, "chọn phương thức thanh toán trước đã !");
        }
        else  {
            JOptionPane.showMessageDialog(null, "bạn đã thanh toán thành công số tiền : " + Order.currentOrder.getprice() + "VND");
            // đưa giá về 0 sau khi ấn thanh toán
            Order.currentOrder.setTotalPrice(0.0);
            // đưa bảng về rỗng sau khi ấn thanh toán
            Order.currentOrder.getModel().setRowCount(0);
            // hiển thị lại giá
            pay.getTotalLabel().setText("Total: " + Order.currentOrder.getprice());
            Order.currentOrder.setCount(0);
            pay.getPayButton().setEnabled(false);
            //sau khi thanh toán thì ẩn cái mã giảm giá  của 3 radio
            pay.getCashDiscountLabel().setVisible(false);
            pay.getCardDiscountLabel().setVisible(false);
            pay.getOnlineDiscountLabel().setVisible(false);

            // vô hiệu hóa các radio thanh toán khi đã thanh toán
            pay.getCashPayment().setEnabled(false);
            pay.getCardPayment().setEnabled(false);
            pay.getOnlinePayment().setEnabled(false);

            //đưa giá và dếmở Order về 0 sau khi thannh toán và thoát giao diện

            Order.currentOrder.getLblRePrice().setText(""+0);
            Order.currentOrder.getLblReTotal().setText(""+0);

            //vô hiệu hóa nút
            pay.getCheckCodeButton().setEnabled(false);
            // vô hiệu hóa textfied
           pay.getDiscountCodeField().setEnabled(false);


            var pay = Pay.currentPay.getPaymentTableData();
            Pointer.setCurrentWatercounters(new Watercounters(pay));

            // tiến hành đưa thông tin vừa thanh toán đến bảng Watercounters



//            Pointer.currentWatercounters.model = new DefaultTableModel();
//
////            Pointer.currentWatercounters.setWatercounterstable(new JTable(model));
//            JScrollPane scrollPane = new JScrollPane(   Pointer. currentWatercounters.getWatercounterstable());
//            Pointer. currentWatercounters.getWatercounterstable().setFillsViewportHeight(true);
//            Pointer. currentWatercounters.add(scrollPane, BorderLayout.CENTER);



        }
    }
}
