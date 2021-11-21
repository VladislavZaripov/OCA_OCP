package OCP.Chapter4;
import java.util.*;
import java.util.stream.*;
public class CollectingResults {
    public static void main(String[] args) {

    // Collecting Using Basic Collectors
        Stream <String> stream1 = Stream.of("one", "two", "three");
        Double results1 = stream1.collect
                (Collectors.averagingInt(String::length));
        System.out.println(results1);                     // 3.6666666666666665

        Stream <String> stream2 = Stream.of("one", "two", "three");
        String results2 = stream2.collect
                (Collectors.joining(", "));
        System.out.println(results2);                     // one, two, three

    // Collecting into Maps
        Stream <String> stream3 = Stream.of("one", "two", "three");
        Map <String, Integer> map1 = stream3.collect
                (Collectors.toMap(s -> s, String::length));
        System.out.println(map1);                         // {one=3, three=5, two=3}

        Stream <String> stream4 = Stream.of("one", "two", "three");
        Map <Integer, String> map2 = stream4.collect
                (Collectors.toMap(String::length,k->k,(s1,s2) -> s1+", "+s2));
        System.out.println(map2);                         // {3=one, two, 5=three}

        Stream <String> stream5 = Stream.of("one", "two", "three");
        TreeMap<Integer, String> map3 = stream5.collect
                (Collectors.toMap(String::length,k->k,(s1,s2) -> s1+", "+s2,TreeMap::new));
        System.out.println(map3);                         // {3=one, two, 5=three}

    // Collecting Using Grouping, Partitioning, and Mapping
        Stream <String> stream6 = Stream.of("one", "two", "three");
        Map <Integer, List<String>> map4 = stream6.collect
                (Collectors.groupingBy(String::length));
        System.out.println(map4);                         // {3=[one, two], 5=[three]}

        Stream <String> stream7 = Stream.of("one", "two", "three");
        Map <Integer, Set<String>> map5 = stream7.collect
                (Collectors.groupingBy(String::length,Collectors.toSet()));
        System.out.println(map5);                         // {3=[one, two], 5=[three]}

        Stream <String> stream8 = Stream.of("one", "two", "three");
        TreeMap <Integer, Set<String>> map6 = stream8.collect
                (Collectors.groupingBy(String::length,TreeMap::new,Collectors.toSet()));
        System.out.println(map6);                         // {3=[one, two], 5=[three]}

        Stream <String> stream9 = Stream.of("one", "two", "three");
        Map <Boolean, List <String>> map7 = stream9.collect
                (Collectors.partitioningBy(s -> s.length() < 7));
        System.out.println(map7);                         // {false=[], true=[one, two, three]}

        Stream <String> stream10 = Stream.of("one", "two", "three");
        Map <Boolean, Set <String>> map8 = stream10.collect
                (Collectors.partitioningBy(s -> s.length() < 4,Collectors.toSet()));
        System.out.println(map8);                         // {false=[three], true=[one, two]}

        Stream <String> stream11 = Stream.of("one", "two", "three");
        Map <Boolean, Long> map9 = stream11.collect
                (Collectors.partitioningBy(s -> s.length() < 4,Collectors.counting()));
        System.out.println(map9);                         // {false=1, true=2}
    }}

