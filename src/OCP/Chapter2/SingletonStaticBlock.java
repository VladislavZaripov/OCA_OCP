package OCP.Chapter2;

public class SingletonStaticBlock {
    private SingletonStaticBlock(){}
    private static final SingletonStaticBlock Instance;
    static {Instance = new SingletonStaticBlock();}
    public static SingletonStaticBlock getInstance() {return Instance;}
}

