package OCP.Chapter2;

public class Singleton {
    private Singleton(){}
    private static final Singleton Instance = new Singleton();
    public static Singleton getInstance() {return Instance;}

    private int num = 0;
    public synchronized int getNum () {return num;}
    public synchronized void addNum (int amount) {num = num + amount;}
}
class User{
    int numUser;
    public static void main(String[] args) {
        User user = new User();
        Singleton singleton = Singleton.getInstance();
        singleton.addNum(5);
        user.numUser = singleton.getNum();
        System.out.println(user.numUser);
    }}
