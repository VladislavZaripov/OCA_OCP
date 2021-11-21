package OCP.Chapter3;
import java.util.*;
import java.util.function.*;
public class newMethods{}

class removeIF {  /* boolean removeIF (Predicate <? super E> filter) */
    public static void main(String[] args) {
        List <String> list = new ArrayList<>();
        list.add("one"); list.add("two"); list.add("three");
        list.removeIf(s->s.startsWith("t"));
        System.out.println(list);}                       // [one]
}
class replaceAll {  /* void replaceAll (UnaryOperator <E> o) */
    public static void main(String[] args) {
        List <Integer> list = Arrays.asList(1,2,3);
        list.replaceAll(s -> s*2);
        System.out.println(list);}                       // [2, 4, 6]
}
class forEach {
    public static void main(String[] args) {
        List <Integer> list = Arrays.asList(1,2,3);
        list.forEach(s -> System.out.print(s + " "));}   // 1 2 3
}
class putIfAbsent {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"one");       map.putIfAbsent(1,"four");      // 1=one
        map.put(2,null);        map.putIfAbsent(2,"two");       // 2=two
                                map.putIfAbsent(3,"three");     // 3=three
        System.out.println(map);} // {1=one, 2=two, 3=three}
}
class merge {
    public static void main(String[] args) {
        BinaryOperator <String> mapper1 = (v1, v2) -> v1.length()>v2.length()? v1 : v2;
        Map <Integer, String> map1 = new HashMap<>();
        map1.put(1,"one");       map1.merge(1,"oonnee",mapper1);   // 1=oonnee
        map1.put(2,"two");       map1.merge(2,"t",mapper1);        // 2=two
        map1.put(3,null);        map1.merge(3,"three",mapper1);    // 3=three
                                 map1.merge(4,"four",mapper1);     // 4=four
        System.out.println(map1); // {1=oonnee, 2=two, 3=three, 4=four}

        BinaryOperator <String> mapper2 = (v1, v2) -> null;
        Map <Integer, String> map2 = new HashMap<>();
        map2.put(1,"one");       map2.merge(1,"oonnee",mapper2);   // remove
                                 map2.merge(2,"two",mapper2);      // 2=two
        System.out.println(map2);} // {2=two}
}
class computeIfPresent_computeIfAbsent { /* NOT on the OCP exam*/
    public static void main(String[] args) {
        BiFunction <String, Integer, Integer> mapper1 = (k,v) -> v+1;
        Map <String, Integer> map1 = new HashMap<>();
        map1.put("one",1);       map1.computeIfPresent("one",mapper1);   // one=2
        map1.put("two",null);    map1.computeIfPresent("two",mapper1);   // two=null
                                 map1.computeIfPresent("three",mapper1); // nothing
        System.out.println(map1); // {one=2, two=null}

        Function <String, Integer> mapper2 = (k) -> 1;
        Map <String, Integer> map2 = new HashMap<>();
        map2.put("one",15);      map2.computeIfAbsent("one",mapper2);    // one=15
        map2.put("two",null);    map2.computeIfAbsent("two",mapper2);    // two=1
                                 map2.computeIfAbsent("three",mapper2);  // three=1
        System.out.println(map2); // {one=15, three=1, two=1}

        Map <String, Integer> map3 = new HashMap<>();
        map3.put("one",1);       map3.computeIfPresent("one",(k,v) -> null); // remove
                                 map3.computeIfPresent("two",(k,v) -> null); // nothing
        map3.put("three",3);     map3.computeIfAbsent("three",k -> null);    // three=3
                                 map3.computeIfAbsent("four",k -> null);     // nothing

        System.out.println(map3);} // {three=3}
}
