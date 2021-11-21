package OCP.Chapter3;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JAVA protect us with wrong type in ArrayList */
public class Bounds {

    public static void printList(List<Object> list) {
        for (Object x: list) System.out.println(x);
    }
    public static void main(String[] args) {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
    //  printList(keywords);                    // DOES NOT COMPILE

        List <Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(42));
    //  List<Object> objects = numbers;         // DOES NOT COMPILE
    //  objects.add("text");                    // Java protect us from this
        System.out.println(numbers.get(1));

        Integer[] numbers1 = { new Integer(42)};
        Object[] objects = numbers1;            // It's OK but...
        objects[0] = "forty two";               // throws ArrayStoreException
    }}

/* Unbounded wildcard */
class Unbounded {

    public static void prinList (List<?> list){
        for (Object x: list) System.out.println(x);
    }
    public static void main (String[] args){
        List <String> keywords = new ArrayList<>();
        keywords.add("text");
        prinList(keywords);                                 // text

        List <Integer> numbers = new ArrayList<>();
        numbers.add(new Integer(42));
        List <?> objects = numbers;
    //  objects.add("text");    // DOES NOT COMPILE, List <?> become immutable
        System.out.println(numbers.get(1));
    }}

/* Upper-Bounded wildcard */
class UpperBounded{

    public static void main(String[] args) {
        ArrayList <Integer> intnum = new ArrayList<>();
    //  ArrayList <          Number> numbers = intnum;      // DOES NOT COMPILE
        ArrayList <? extends Number> numbers = intnum;
        intnum.add(2);
    //  numbers.add(2);  // DOES NOT COMPILE, List <? extends Number> become immutable
    }}

/* Lower-Bounded wildcard */
class LowerBounded{

    public static void add (List <? super String> list){
        list.add("addtext");                                // Lower-Bounded is Mutable!
    }
    public static void main (String[] args){
        List <String> strings = new ArrayList<String>();
        strings.add("text");
        List <Object> objects = new ArrayList<Object>(strings);
        add(strings);
        add(objects);

        List <? super IOException> exceptions = new ArrayList<Exception>();
    //  exceptions.add(new Object());                       // DOES NOT COMPILE
    //  exceptions.add(new Exception());                    // DOES NOT COMPILE
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());
    }}
