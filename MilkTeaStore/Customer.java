package MilkTeaStore;

public class Customer {
    private String cusId;
    private String name;
    private Ordering ordering;
    private int point;
    public Customer(String cusId, String name, Ordering ordering, int point) {
        super();
        this.cusId = cusId;
        this.name = name;
        this.ordering = ordering;
        this.point = point;
    }

}