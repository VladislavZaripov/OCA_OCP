package OCP.Chapter4;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.*;
public class PrimitiveStreams {}

class CreatingPrimitive {
    public static void main(String[] args) {
        IntStream    intStream    = IntStream.empty();
        LongStream   longStream   = LongStream.of(1,2,3);
        DoubleStream doubleStream = DoubleStream.of(1.0,2.0,3.0);

        DoubleStream random    = DoubleStream.generate(Math::random);
        DoubleStream fractions = DoubleStream.iterate(.5,d -> d/2);

        IntStream range123  = IntStream.range(1,4);
        IntStream range1234 = IntStream.rangeClosed(1,4);

        /*Mapping methods between types of streams*/
        Stream <String> stream = Stream.of("one", "two", "three");
        IntStream intStream1 = stream.mapToInt(x->x.length());
        intStream1.forEach(System.out::print);                                  // 335

        /*Optional with Primitive Streams*/
        IntStream intStream2 = IntStream.rangeClosed(1,10);

        OptionalInt optionalInt1 = intStream2.max();
        optionalInt1.ifPresent(System.out::println);
        int num1 = optionalInt1.getAsInt();
        int num2 = intStream2.sum();
        OptionalDouble optionalDouble = intStream2.average();
        Double num3 = optionalDouble.orElseGet(()->Double.NaN);
    }}
