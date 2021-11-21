package OCA.DatesAndTimes;        /* LocalTime is immutable instance without time or time zones */

        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.LocalTime;
        public class LocalTimeClass {
        static void print (LocalTime x) {System.out.println(x);}
        static void print (int x) {System.out.println(x);}
        static void print (boolean x) {System.out.println(x);}
        static void print (LocalDateTime x) {System.out.println(x);}
        public static void main(String[] args) {
        int num = 20;
        LocalTime time1 = LocalTime.of(05,05);
        LocalTime time2 = LocalTime.of(05,05,05);
        LocalTime time3 = LocalTime.of(23,59,59,999999999);
        LocalTime time4 = LocalTime.now();
        LocalTime time5 = LocalTime.parse("15:08:23");
        // LocalTime time6 = LocalTime.of(120,12);         DateTimeException
        // LocalTime time7 = LocalTime.of(12,-2147483649);
        // Compilation error, int -2147483648:2147483647

        print(time1.MIN);                   // print: 00:00 (NO change)
        print(time1.MAX);                   // print: 23:59:59.999999999 (NO change)
        print(time1.MIDNIGHT);              // print: 00:00 (NO change)
        print(time1.NOON);                  // print: 12:00 (NO change)

        print(time3.getNano());             // print: 999999999
        print(time3.getSecond());           // print: 59
        print(time3.getMinute());           // print: 59
        print(time3.getHour());             // print: 23

        print(time1.isAfter(time3));        // print: false
        print(time1.isBefore(time3));       // print: true

        print(time3.minusNanos(num));       // print: 23:59:59.999999979
        print(time3.minusSeconds(num));     // print: 23:59:39.999999999
        print(time3.minusMinutes(num));     // print: 23:39:59.999999999
        print(time3.minusHours(num));       // print: 03:59:59.999999999

        print(time3.plusNanos(num));        // print: 00:00:00.000000019
        print(time3.plusSeconds(num));      // print: 00:00:19.999999999
        print(time3.plusMinutes(num));      // print: 00:19:59.999999999
        print(time3.plusHours(num));        // print: 19:59:59.999999999

        print(time3.withNano(num));         // print: 23:59:59.000000020
        print(time3.withSecond(num));       // print: 23:59:20.999999999
        print(time3.withMinute(num));       // print: 23:20:59.999999999
        print(time3.withHour(num));         // print: 20:59:59.999999999

        print(time3.atDate(LocalDate.of(2000,12,12)));
        // print: 2000-12-12T23:59:59.999999999
        }}
