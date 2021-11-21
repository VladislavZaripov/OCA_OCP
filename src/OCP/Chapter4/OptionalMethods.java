package OCP.Chapter4;
import java.util.Optional;
public class OptionalMethods {}

class Human {
    public static Optional <Double> average (int... nums){
        Double sum = 0.0;
        if (nums.length == 0) return Optional.empty();
        else for (int num: nums) sum +=num;
        return Optional.of (sum/nums.length);
    }

    public static void print (Optional <Double> opt){
        if (opt.isPresent()) System.out.println(opt.get());
    }

    public static void main(String[] args) {
        Optional <Double> opt1 = average(12,12,12);
        Optional <Double> opt2 = average();
        System.out.println(opt1);               // Optional[12.0]
        System.out.println(opt2);               // Optional.empty

        print(opt1);                            // 12.0
        print(opt2);                            // nothing
        System.out.println(opt1.get());         // 12.0
    //  System.out.println(opt2.get());         // NoSuchElementException

        System.out.println(opt1.orElse      (Double.NaN));                        // 12.0
        System.out.println(opt1.orElseGet   (() -> Math.random()));               // 12.0
        System.out.println(opt1.orElseThrow (() -> new IllegalStateException())); // 12.0

        System.out.println(opt2.orElse      (Double.NaN));                        // NAN
        System.out.println(opt2.orElseGet   (() -> Math.random()));               // 0.00...
        System.out.println(opt2.orElseThrow (() -> new IllegalStateException())); // Exception
    }}
