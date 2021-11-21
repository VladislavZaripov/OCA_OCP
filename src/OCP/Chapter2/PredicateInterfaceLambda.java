package OCP.Chapter2;
import java.util.function.Predicate;

class Human2 {
    private String name; private boolean knowJava;
    public Human2(String name, boolean knowJava)    {
        this.name = name; this.knowJava = knowJava;}
    public boolean knowJava() {return knowJava;}}

public class PredicateInterfaceLambda {
    private static void print (Human2 human2, Predicate <Human2> interf){
        if (interf.test(human2)) System.out.println("Yes");
        else System.out.println("No");}

    public static void main(String[] args) {
        print(new Human2("Man1", true), a -> a.knowJava());                  // Yes
        print(new Human2("Man2",false),(Human2 a)->{return a.knowJava();});   // No
    }}
