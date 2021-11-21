package OCA;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Lambda {
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        list.add(4);list.add(5);list.add(6);
        list.forEach((Integer value) -> System.out.println(value));
        list.forEach((value) -> System.out.println(value));
        list.forEach(value -> System.out.println(value));
        list.forEach(System.out::println);
        System.out.println(sumALL(list, value -> value % 2 == 0));
        System.out.println(sumALL(list, value -> value > 3));
        System.out.println(sumALL(list, value -> value < 3));


    }
    private static int sumALL(ArrayList<Integer> list, Predicate<Integer> value){
        int total = 0;
        for (Integer num : list)
            if (value.test(num))
            total = total+num;
        return total;
    }
}
