package OCA;

import java.util.ArrayList;
import java.util.ListIterator;

public class Swap {

    String name;

    Swap(String name){
        this.name = name;
    }


    public static void main(String[] args) {
        Swap swap1 = new Swap("one");
        Swap swap2 = new Swap("two");

        swap(swap1,swap2);
        System.out.println(swap1.name);
        System.out.println(swap2.name);
        long n = 1;
        n = ret(n);
        System.out.println(n);

        String qqq = "qwerty";
        boolean www = qqq.substring(0,2).startsWith("q");
        System.out.println(www);

        StringBuilder stringBuilder = new StringBuilder(123);
        System.out.println(stringBuilder);

        int[]  Myltiarr [] = {{1,2,3,4}, {3,5,6,7,8}, {5,6,7,8}};


        ArrayList <Integer> arr = new ArrayList<Integer>();
        arr.add(5);
        arr.add(4);
        arr.add(5);
        arr.add(4);
        arr.add(5);
        arr.add(4);

        ListIterator<Integer> iterator = arr.listIterator();
        while (iterator.hasNext()){
            if (iterator.next()==5) iterator.set(4);
           }

        for (Integer list : arr) System.out.println(list);

        ArrayList <Long> list4 = new ArrayList<>();
        list4.add(10l);

        String stringBuilder1 = "123456";
        CharSequence chars = stringBuilder1.subSequence(2,4);
        System.out.println(chars);

        int jjj = 7>5?
                        6<5?
                        10
                        :6
                  :7;


    }

    public static void swap (Swap one, Swap two){
        Swap temp;
        temp = one;
        one = two;
        two = temp;
    }

    static long ret (long q){
        int a = 5;
        q = a;
        return q;
    }



}
