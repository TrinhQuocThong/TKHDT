package MilkTeaStore;

import java.util.List;

public interface IServiceObserver {
    public void update(String cusId, List<Beverage> drinks, String address);
}