package OCP.Chapter3;
import java.util.*;

public class SetInterface {

    /* common collections methods */
    // boolean add (E element)
    // boolean remove (Object object)  -  removes a single matching
    // boolean isEmpty ()
    // int size ()
    // void clear ()
    // boolean contains (Object object)

    public static void main(String[] args) {
        Set <Integer> set1 = new HashSet <> ();
    //      HashSet - don't allow duplicate, use hashCode() method
    //      lost order of elements
    //      Read, add or remove - O(1)
        boolean b1 = set1.add(66);      // true
        boolean b2 = set1.add(10);      // true
        boolean b3 = set1.add(66);      // false
        boolean b4 = set1.add(8);       // true
        for (Integer integer: set1) System.out.print(integer + " "); // 66 8 10

        Set <Integer> set2 = new TreeSet <> ();
    //      TreeSet - don't allow duplicate, use NavigableSet Interface
    //      always sort elements in tree structure
    //      Read, add or remove - O(log n)
        boolean b5 = set2.add(66);      // true
        boolean b6 = set2.add(10);      // true
        boolean b7 = set2.add(66);      // false
        boolean b8 = set2.add(8);       // true
        for (Integer integer: set2) System.out.print(integer + " "); // 8 10 66

        /* NavigableSet Interface */
    // E lower(E e)   Returns greatest element that is <  e, or null if no such element
    // E floor(E e)   Returns greatest element that is <= e, or null if no such element
    // E ceiling(E e) Returns smallest element that is >= e, or null if no such element
    // E higher(E e)  Returns smallest element that is >  e, or null if no such element
    }}

