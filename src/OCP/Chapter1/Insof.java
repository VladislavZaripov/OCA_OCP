package OCP.Chapter1;
public class Insof {
class Nested1 extends Insof{}
class Nested2{}

    public static void main(String[] args) {
        Insof ch1 = new Insof();
        Insof ch2 = null;
        Insof ch3;

        System.out.println(ch1 instanceof Insof);        // true
        System.out.println(ch2 instanceof Insof);        // false
    //  System.out.println(ch3 instanceof Chapter1);     // not compile
    //  System.out.println(ch2 instanceof String);       // not compile
        System.out.println(ch2 instanceof Nested1);      // false
    //  System.out.println(ch2 instanceof Nested2);      // not compile
        System.out.println(ch2 instanceof Runnable);     // false
    }}
