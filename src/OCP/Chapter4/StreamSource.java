package OCP.Chapter4;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamSource {}

class CreatingStream {
    public static void main(String[] args) {
        Stream <String>  empty  = Stream.empty();
        Stream <Integer> single = Stream.of(10);
        Stream <Integer> multi  = Stream.of(1,2,3);

        List<String> list = Arrays.asList("a", "b", "c");
        Stream <String> fromList = list.stream();
        Stream <String> fromListParallel = list.parallelStream();       // for parallelism

        Stream <Double> randoms = Stream.generate(()-> Math.random());  // Infinite Stream
        Stream <Integer> oddNum = Stream.iterate(1, (n) -> n + 1);      // Infinite Stream
    }}

class methods {
    public static void main(String[] args) {
/* Terminal operations - finish the stream*/
// for Infinite Stream some methods don,t stop until we killed the program (look Table 4.4)

        // long count ()
        Stream <String> stream1 = Stream.of("one", "two", "three");
        System.out.println(stream1.count());                            // 3

        // Optional <T> min (<? super T> comparator)
        // Optional <T> max (<? super T> comparator)
        Stream <String> stream2 = Stream.of("one", "two", "three");
        Optional <String> min = stream2.min ((s1,s2) -> s1.length()-s2.length());
        min.ifPresent(System.out :: println);                           // one

        Optional <?> empty = Stream.empty().min ((s1,s2) -> 0);
        System.out.println(empty.isPresent());                          // false

        // Optional <T> findAny ()
        // Optional <T> findFirst ()
        Stream <String> stream3 = Stream.of("one", "two", "three");
        Stream <String> infinite1 = Stream.generate(() -> "Inf");
        Optional <String> any1 = stream3.findAny();
        System.out.println(any1);                                       // Optional[one]
        Optional <String> any2 = infinite1.findAny();
        System.out.println(any2);                                       // Optional[Inf]

        Stream <String> stream4 = Stream.of("one", "two", "three");
        Stream <String> infinite2 = Stream.generate(() -> "Inf");
        Optional <String> first1 = stream4.findFirst();
        System.out.println(first1);                                     // Optional[one]
        Optional <String> first2 = infinite2.findFirst();
        System.out.println(first2);                                     // Optional[Inf]

        // boolean anyMatch  (Predicate <? super T> predicate)
        // boolean allMatch  (Predicate <? super T> predicate)
        // boolean noneMatch (Predicate <? super T> predicate)
        List <String> list = Arrays.asList("one", "2", "three");
        Stream <String> infinite3 = Stream.generate(() -> "Inf");
        Predicate <String> predicate = (x) -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(predicate));          // true
        System.out.println(list.stream().allMatch(predicate));          // false
        System.out.println(list.stream().noneMatch(predicate));         // false
        System.out.println(infinite3.anyMatch(predicate));              // true

        // void forEach (Consumer <? super T> action)
        Stream <String> stream5 = Stream.of("one", "two", "three");
        stream5.forEach(System.out ::print);                            // onetwothree

        //1.           T  reduce (T identity, BinaryOperator <T> accumulator)
        //2. Optional <T> reduce (            BinaryOperator <T> accumulator)
        //3.       <U> U  reduce (U identity, BiFunction <U, ? super T, U> accumulator,
        //                                                 BinaryOperator <U> combiner)
        Stream <String> stream6 = Stream.of("o", "n", "e");
        System.out.println(stream6.reduce("", String::concat));         // one
        Stream <Integer> stream7 = Stream.of(1,2,3);
        System.out.println(stream7.reduce(10, (x1,x2) -> x1*x2));       // 60

        //1. <R> R collect (Supplier <R>, BiConsumer <R, ? super T> accumulator,
        //                                           BiConsumer <R, R> combiner)
        //2. <R, A> R collect (Collector <? super T, A, R> collector
        Stream <String> stream8 = Stream.of("o", "n", "e");
        StringBuilder str = stream8.collect(StringBuilder::new,
                  StringBuilder::append, StringBuilder::append);
        System.out.println(str);                                        // one

/* Intermediate operations - do not finish the stream*/

        // Stream <T> filter (Predicate <? super T> predicate)
        Stream <String> stream9 = Stream.of("one", "two", "three");
        stream9.filter(x -> x.startsWith("t")).forEach(System.out::print);  // twothree

        // Stream <T> distinct()
        Stream <String> stream10 = Stream.of("one", "two", "one");
        stream10.distinct().forEach(System.out::print);                 // onetwo

        // Stream <T> limit (int maxSize)
        // Stream <T> skip  (int n)
        Stream <Integer> stream11 = Stream.iterate(1,x -> x+1);
        stream11.skip(5).limit(2).forEach(System.out::print);           // 67

        // <R> Stream <R> map (Function <? super T, ? extends R> mapper)
        Stream <String> stream12 = Stream.of("one", "two", "one");
        stream12.map(String::length).forEach(System.out::print);        // 333

        // <R> Stream <R> flatMap (Function <? super T, ? extends Stream <? extends R>> mapper)
        List <String> list2 = Arrays.asList();
        List <String> list3 = Arrays.asList("one");
        List <String> list4 = Arrays.asList("two","three");
        Stream <List<String>> stream13 = Stream.of(list2,list3,list4);
        stream13.flatMap(x -> x.stream()).forEach(System.out::print);   // onetwothree

        // Stream <T> sorted ()
        // Stream <T> sorted (Comparator <? super T> comparator)
        Stream <Integer> stream14 = Stream.of(3,1,2);
        stream14.sorted().forEach(System.out::print);                   // 123
        Stream <Integer> stream15 = Stream.of(3,1,2);
        Comparator <Integer> comparator = (x1,x2) -> x2-x1;
        stream15.sorted(comparator).forEach(System.out::print);         // 321

        // Stream <T> peek (Consumer <? super T> action)
        Stream <Integer> stream16 = Stream.of(1, 2, 3);
        stream16.peek(x-> System.out.print(x*2)).forEach(System.out::print);    // 214263
    }}
