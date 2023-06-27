package MilkTeaStore;

public  class ToppingFactory {
    public Topping createTopping(String toppingName, int quantity){
        if(toppingName.equalsIgnoreCase("Pudding")){
            return new Pudding(quantity);
        }
        else if(toppingName.equalsIgnoreCase("GrassJelly")){
            return new GrassJelly(quantity);
        }
        else if(toppingName.equalsIgnoreCase("Pearl")){
            return new Pearl(quantity);
        }
        return null;
    }
}