package OCP.Chapter3;
import java.util.*;

public class ListInterface {

    /* common collections methods */
    // boolean add (E element)
    // boolean remove (Object object)  -  removes a single matching
    // boolean isEmpty ()
    // int size ()
    // void clear ()
    // boolean contains (Object object)

    public static void main(String[] args) {
        List <String> list1 = new ArrayList <> ();
    //      ArrayList - good choose when more reading than writing
    //      Read - O(1)
    //      Add or remove - slower than reading

        List <String> list2 = new LinkedList <> ();
    //      LinkedList - implements List and Queue
    //      Read, add or remove from the beginning and end - O(1)
    //      Read, add or remove from any place - O(n)

        List <String> list4 = new Vector <> ();
    //      Vector - old and slow version ArrayList until Java 1.2

        List <String> list3 = new Stack <> ();
    //      Stack - old version, add and remove elements from the top
    //      now use ArrayDeque

        /* List methods */
        // void add (E element)
        // void add (int index, E element)
        // E get (int index,)
        // int indexOf (Object o)
        // int lastIndexOf (Object o)
        // void remove (int index)
        // E set (int index, E e)   -   replaces element and return original

        /* Looping through a List */
        for (String string : list1){
            System.out.println(string);
        }
        Iterator iter1 = list1.iterator();
        while (iter1.hasNext()){
            String string = (String)iter1.next();
            System.out.println(string);
        }
        Iterator <String> iter2 = list1.iterator();
        while (iter2.hasNext()){
            String string = iter2.next();
            System.out.println(string);
        }}}

