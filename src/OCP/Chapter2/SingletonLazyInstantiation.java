package OCP.Chapter2;

public class SingletonLazyInstantiation {
    private SingletonLazyInstantiation() {}
    private static SingletonLazyInstantiation Instance;

    public static SingletonLazyInstantiation getInstance() {
        if(Instance == null) Instance = new SingletonLazyInstantiation();
        return Instance;}                       // NOT THREAD-SAFE
}
