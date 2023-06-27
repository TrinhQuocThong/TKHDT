package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import MilkTeaStore.Beverage;
import MilkTeaStore.Topping;
import service.IProductService;
import service.ProductServiceImp;
import view.Order;

public class OrderController implements ActionListener {
    private Order orderView;
    private IProductService productService ;

    public OrderController(Order orderView) {
        super();
        this.orderView = orderView;
        productService = new ProductServiceImp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String str;
        str = e.getActionCommand();

    }

    public Beverage setBeverage(String name) {
        return productService.setBeverage(name);
    }

    public double getTotalPrice(Beverage beverage, String flavour, List<Topping> toppingList, String size) {

        return productService.getTotalPrice(beverage, flavour, toppingList, size);
    }
    public Topping createTopping(String name, int quantity){
        return productService.createTopping(name,quantity);
    }
}