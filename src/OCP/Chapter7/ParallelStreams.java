package OCP.Chapter7;
import java.util.Arrays;
import java.util.stream.*;
public class ParallelStreams {
    public static void main(String[] args) {
/* Create by method parallel () */
// Intermediate stream operation. Convert serial stream into parallel stream.
        Stream <Integer> stream1 = Arrays.asList(1,2,3,4,5).stream();
        System.out.println(stream1.isParallel());                       // false
        Stream <Integer> stream2 = stream1.parallel();
        System.out.println(stream2.isParallel());                       // true

/* Create by method parallelStream () */
// Method of Collection interface. Convert collection into the stream.
        Stream <Integer> stream3 = Arrays.asList(1,2,3,4,5).parallelStream();
        System.out.println(stream3.isParallel());                       // true
    }}
