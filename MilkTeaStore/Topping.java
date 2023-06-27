package MilkTeaStore;

public abstract class Topping {

    private int quantity;


//	public ToppingDecorator(ISizeStrategy size, IPriceStrategy pricePercentage, IFlavorStrategy flavor,
//			boolean isOwnCup, Drink drink) {
//		super(size, pricePercentage, flavor, isOwnCup);
//		this.drink = drink;
//	}

    public Topping() {

    }

    public Topping( int quantity) {

        this.quantity = quantity;
    }

    public abstract String getDiscription();

    public abstract double getPrice();



    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}