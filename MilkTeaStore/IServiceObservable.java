package MilkTeaStore;

public interface IServiceObservable {
    public void registerServer(IServiceObserver service);
    public void removeServer(IServiceObserver service);
    public void nofity();
}