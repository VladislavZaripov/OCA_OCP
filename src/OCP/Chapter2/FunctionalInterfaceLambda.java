package OCP.Chapter2;

import java.util.function.Predicate;

@FunctionalInterface
abstract interface Interf{
    public static final int num = 10;
    public default void print1 () {System.out.println("Default method");}
    public static  void print2 () {System.out.println("Static method");}
    public abstract boolean test (Human1 a);
}
class Human1 {
    private String name; private boolean knowJava;
    public Human1(String name, boolean knowJava)    {
        this.name = name; this.knowJava = knowJava;}
    public boolean knowJava() {return knowJava;}}

public class FunctionalInterfaceLambda {
    private static void print (Human1 human, Interf interf){
        if (interf.test(human)) System.out.println("Yes");
        else System.out.println("No");}

    public static void main(String[] args) {
        print(new Human1("Man1", true), a -> a.knowJava());                  // Yes
        print(new Human1("Man2",false),(Human1 a)->{return a.knowJava();});   // No
    }}