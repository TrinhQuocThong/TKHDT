package MilkTeaStore;

import java.util.ArrayList;

public abstract class Beverage {
    private double price;
    private IFlavourStrategy flavour;
    private ISizeStrategy size;
    private IPriceStrategy priceStrategy = new NormalPrice();
    private ToppingFactory toppingFactory = new ToppingFactory();
    private ArrayList<Topping> toppingList = new ArrayList<Topping>();

    //	private boolean isOwnCup;
    public Beverage() {

    }
    public Beverage(double price,IFlavourStrategy flavour, ISizeStrategy size) {
        super();
        this.price = price;
        this.flavour = flavour;
        this.size = size;
//		this.size = new Small();
//		this.flavour = new ChocolateFlavour();

//		this.priceStrategy = new NormalPrice();


//		this.isOwnCup = isOwnCup;
    }

    //	public String getDescription() {
//		return drink.getDiscription();
//	}
    public abstract String getDescription();
    public String getFullDescription(){
        StringBuilder sb = new StringBuilder();
        sb.append(getDescription());
        sb.append(flavour.getFlavorDiscription()+" ");
        for(Topping topping: toppingList){
            sb.append(" "+topping.getDiscription()+"x"+topping.getQuantity()+" ");
        }
        sb.append(size.getSize());
        return sb.toString();
    }

    public double getTotalPrice() {
        double toppingPrice = 0;
        for(Topping topping : toppingList){
            toppingPrice+=topping.getPrice();
        }
        return priceStrategy.getPrice(size.getPrice() * ( flavour.getPrice()))+toppingPrice ;

//		return priceStrategy.getPrice(5000);






    }

    public double getPoint() {
        return priceStrategy.getPoint(size.getPrice() * (this.getPrice() + flavour.getPrice()));

    }

    public double getPrice() {
        return 5000;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//	cac method ho tro order nuoc
//	*************************************

//public Drink getDrink() {
//		return drink;
//	}

//	public void setDrink(Drink drink) {
//		this.drink = drink;
//	}

    public IFlavourStrategy getFlavour() {
        return flavour;
    }

//	public void setFlavour(IFlavourStrategy flavour) {
//		this.flavour = flavour;
//	}

    public ISizeStrategy getSize() {
        return size;
    }

//	public void setSize(ISizeStrategy size) {
//		this.size = size;
//	}

    public IPriceStrategy getPriceStrategy() {
        return priceStrategy;
    }

    public void setPriceStrategy(IPriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

//	public boolean isOwnCup() {
//		return isOwnCup;
//	}
//
//	public void setOwnCup(boolean isOwnCup) {
//		this.isOwnCup = isOwnCup;
//	}

    //	loai nuoc
//	public void setDrink(String kind) {
//		if(kind.equals("Milktea"))
//			this.drink= new MilkTea();
//		else if(kind.equals("Coffee"))
//			this.drink= new Coffee();
//		else if(kind.equals("Softdrink"))
//			this.drink= new SoftDrink();
//		else if(kind.equals("Juice"))
//			this.drink= new Juice();
//	}


    //	huong vi
    public void setFlavour(String flavour) {
        if(flavour.equals("Chocolate"))
            this.flavour= new ChocolateFlavour();
        else if(flavour.equals("Matcha"))
            this.flavour= new MatchaFlavour();
        else if(flavour.equals("Taro"))
            this.flavour= new TaroFlavour();
        else if(flavour.equals("Orange"))
            this.flavour= new OrangeFlavour();
        else if(flavour.equals("Lemonade"))
            this.flavour= new LemonadeFlavour();
    }


    //	size
    public void setSize(String size) {
        if(size.equalsIgnoreCase("S"))
            this.size= new Small();
        else if(size.equalsIgnoreCase("M"))
            this.size= new Medium();
        else if(size.equalsIgnoreCase("L"))
            this.size= new Large();
    }

    //	them topping
    public void addTopping(String toppingName,int quantity) {
        Topping topping = toppingFactory.createTopping(toppingName,quantity);
        toppingList.add(topping);
    }
    public void addTopping(Topping topping){
        toppingList.add(topping);
    }





    public ToppingFactory getToppingFactory() {
        return toppingFactory;
    }



    public ArrayList<Topping> getToppingList() {
        return toppingList;
    }


//	dat nuoc
//	public Beverage orderBeverage(String kind, String flavour, String size) {
//		Beverage beverage= new Beverage();
//		beverage.setDrink(kind);
//		beverage.setFlavour(flavour);
//		beverage.setSize(size);
//		return beverage;
//	}
//


}