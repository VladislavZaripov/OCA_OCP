package OCP.Chapter5;
import java.text.NumberFormat;
import java.util.Locale;
public class Formatting_Numbers{
    public static void main(String[] args) throws Exception{
// NumberFormat.getInstance(Locale);
        int num = 1_000_000;
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        NumberFormat ge = NumberFormat.getInstance(Locale.GERMANY);
        NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(us.format(num));                     // 1,000,000
        System.out.println(ge.format(num));                     // 1.000.000
        System.out.println(ca.format(num));                     // 1 000 000
// NumberFormat.getCurrencyInstance(Locale);
        double price = 48.11;
        NumberFormat usm = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat rum = NumberFormat.getCurrencyInstance(Locale.getDefault());
        System.out.println(usm.format(price));                  // $48.11
        System.out.println(rum.format(price));                  // 48,11 руб.
// Parse
        String s = "40.11";
        System.out.println(us.parse(s));                        // 40.11
        System.out.println(ge.parse(s));                        // 4011
        System.out.println(ca.parse(s));                        // 40
        System.out.println(us.parse("456qwe"));                 // 456
        System.out.println(us.parse("-2.111х10"));              // -2.111
    //  System.out.println(us.parse("wer"));                    // ParseException
        System.out.println(usm.parse("$48,807.99"));            // 48807.99
    }}
