package MilkTeaStore;

public class Pearl extends Topping {
    private double price=3000;
    public Pearl() {

    }

    public Pearl(int quantity) {
        super(quantity);
    }

    @Override
    public String getDiscription() {
        // TODO Auto-generated method stub
        return " Pearl ";
    }

    public double getPrice() {
        // TODO Auto-generated method stub
        return price*getQuantity();
    }

//	@Override
//	public void addTopping(Drink dr, ArrayList<String> toppings) {
//		// TODO Auto-generated method stub
//
//	}


}