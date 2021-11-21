package OCP.Chapter4;
import java.util.*;
import java.util.function.*;
public class FunctionalInterface {}

//  @FunctionalInterface public class Supplier <T> { public T get(); }
class Supplier1 {
    public static void main(String[] args) {
        Supplier <String> supplier1 = () -> new String();
        Supplier <String> supplier2 = String :: new;
    }}

// @FunctionalInterface public class Consumer   <T>    { void accept (T t); }
// @FunctionalInterface public class BiConsumer <T, U> { void accept (T t, U u); }
class Consumer_BiConsumer {
    public static void main(String[] args) {
        List <String> list = new ArrayList<>();
        Consumer <String> consumer1 = (t) -> list.add(t);
        Consumer <String> consumer2 = list :: add;
        consumer1.accept("one");
        consumer2.accept("two");

        Map <Integer, String> map = new HashMap<>();
        BiConsumer <Integer, String> biConsumer1 = (k,v) -> map.put(k,v);
        BiConsumer <Integer, String> biConsumer2 = map :: put;
        biConsumer1.accept(1, "one");
        biConsumer2.accept(2, "two");
    }}

//  @FunctionalInterface public class Predicate <T> { boolean test (T t); }
//  @FunctionalInterface public class BiPredicate <T, U> { boolean test (T t, U u) }
class Predicate_BiPredicate {
    public static void main(String[] args) {
        Predicate <String> predicate1 = (s) -> s.isEmpty();
        Predicate <String> predicate2 = String::isEmpty;
        System.out.println(predicate1.test(""));                    // true
        BiPredicate <String, String> biPredicate1 = String :: startsWith;
        BiPredicate <String, String> biPredicate2 = (s, p) -> s.startsWith(p);
        System.out.println(biPredicate1.test("one","on"));          // true
    }}

//  @FunctionalInterface public class Function <T, R> { R apply (T t); }
//  @FunctionalInterface public class BiFunction (T, U, R) { R apply (T t, U u); }
class Function_BiFunction {
    public static void main(String[] args) {
        Function <String, Integer> function1 = (x) -> x.length();
        Function <String, Integer> function2 = String :: length;
        System.out.println(function1.apply("one"));                 // 3

        BiFunction <String, String, String> biFunction1 = (s1, s2) -> s1.concat(s2);
        BiFunction <String, String, String> biFunction2 = String :: concat;
        System.out.println(biFunction1.apply("one","two"));         // onetwo
    }}

// @FunctionalInterface public class UnaryOperator <T> extends Function <T, T> {}
// @FunctionalInterface public class BinaryOperator <T> extends BiFunction <T, T, T> {}
