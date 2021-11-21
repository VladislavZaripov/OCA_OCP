package OCP.Chapter3;
public class ComparableInterface {}
//      public interface Comparable <T>
//      {public int compareTo(T o);}

class Human implements Comparable<Human> {
    private String name;
    Human (String name) {this.name = name;}
    @Override public int compareTo(Human o) {return name.compareTo(o.name);}

    public static void main(String[] args) {
        System.out.println(new Human("A1a").compareTo(new Human("BV3")));     // -1
    }}
class Price implements Comparable<Price> {
    private Integer num;
    Price (Integer num) {this.num = num;}
    @Override public int compareTo(Price o) {return num - o.num;}

    public static void main(String[] args) {
        System.out.println(new Price(10).compareTo(new Price(11)));     // -1
    }}
