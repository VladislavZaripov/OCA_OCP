package OCP.Chapter3;
import java.util.*;
public class ComparatorInterface {};

class Dog implements Comparable <Dog>{
    private String name; private Integer weight, age;

    public Dog(String name, Integer weight, Integer age) {
        this.name = name; this.weight = weight; this.age = age;}
    @Override public String toString () {return name + " " + weight + " " + age;}
    @Override public int compareTo (Dog d) {return name.compareTo(d.name);}

    public static void main(String[] args) {
        Comparator <Dog> byWeight = new Comparator <Dog> () {
            public int compare(Dog o1, Dog o2) {return o1.weight - o2.weight;}};
        Comparator <Dog> byAge = (o1, o2) -> o1.age - o2.age;

        List <Dog> dogs = Arrays.asList(new Dog("Bulldog", 20, 10), new Dog("Alabay",30, 5));
        Collections.sort (dogs);        // use compareTo, without @Override will not compile
        System.out.println(dogs);       // [Alabay 20 10, Bulldog 30 5]
        Collections.sort (dogs, byWeight);
        System.out.println(dogs);       // [Bulldog 20 5, Alabay 30 10]
        Collections.sort (dogs, byAge);
        System.out.println(dogs);       // [Alabay 20 10, Bulldog 30 5]
    }}