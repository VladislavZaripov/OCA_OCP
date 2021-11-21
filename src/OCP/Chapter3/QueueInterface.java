package OCP.Chapter3;
import java.util.*;

public class QueueInterface {

    /* common collections methods */
    // boolean add (E element)
    // boolean remove (Object object)  -  removes a single matching
    // boolean isEmpty ()
    // int size ()
    // void clear ()
    // boolean contains (Object object)

    public static void main(String[] args) {

    /* Interface Queue - single-ended queue */
        //  FIFO (first-in, first-out / single-ended queue) - offer / poll / peek
        Queue <Integer> queue1 = new LinkedList<>(); // implements List and Queue
        Queue <Integer> queue2 = new ArrayDeque<>(); // pure queue, more efficient

        //  boolean offer(E e)  Adds back,  returns true         or false
        //  poll()              Removes,    returns next element or null
        //  E peek()                        returns next element or null
        //  boolean add(E e)    Adds back,  returns true         or exception
        //  E remove()          Removes,    returns next element or exception
        //  E element()                     returns next element or exception

    /* Interface Deque (extend Queue) - double-ended queue */
        //  LIFO (last-in,  first-out / STACK) - push  / poll / peek
        Deque <Integer> queue3 = new LinkedList<>(); // implements List and Queue
        Deque <Integer> queue4 = new ArrayDeque<>(); // pure queue, more efficient

        //  void push(E e)      Adds front
        //  E pop()             Removes,    returns next element or exception
    }}
