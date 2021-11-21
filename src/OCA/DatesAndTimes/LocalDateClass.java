package OCA.DatesAndTimes;        /* LocalDate is immutable instance without time or time zones */

        import java.time.*;
        public class LocalDateClass {
        static void print (LocalDate x) {System.out.println(x);}
        static void print (LocalDateTime x)   {System.out.println(x);}
        static void print (boolean x)   {System.out.println(x);}
        static void print (DayOfWeek x)   {System.out.println(x);}
        static void print (long x)   {System.out.println(x);}
        static void print (Month x)   {System.out.println(x);}
        public static void main(String[] args) {

        LocalDate date1 = LocalDate.parse("2000-12-05");
        LocalDate date2 = LocalDate.of(2019,12,01);
        LocalDate date3 = LocalDate.of(2019, Month.DECEMBER,01);
        LocalDate date4 = LocalDate.now();

        print(date1.isAfter(date2));                  // print: false
        print(date1.isBefore(date2));                 // print: true

        print(date1.plusDays(1));                     // print: 2000-12-06 (NO change)
        print(date1.plusWeeks(1));                    // print: 2000-12-12 (NO change)
        print(date1.plusMonths(1));                   // print: 2001-01-05 (NO change)
        print(date1.plusYears(1));                    // print: 2001-12-05 (NO change)

        print(date1.minusDays(1));                     // print: 2000-12-04 (NO change)
        print(date1.minusWeeks(1));                    // print: 2000-11-28 (NO change)
        print(date1.minusMonths(1));                   // print: 2000-11-05 (NO change)
        print(date1.minusYears(1));                    // print: 1999-12-05 (NO change)

        print(date1.withDayOfMonth(10));              // print: 2000-12-10 (NO change)
        print(date1.withDayOfYear(10));               // print: 2000-01-10 (NO change)
        print(date1.withMonth(10));                   // print: 2001-10-05 (NO change)
        print(date1.withYear(10));                    // print: 0010-12-05 (NO change)

        print(date1.atTime(16,30));
        // print: 2000-12-05T16:30  (NO change)
        print(date1.atTime(16,30,20));
        // print: 2000-12-05T16:30:20  (NO change)
        print(date1.atTime(16,30,20,300));
        // print: 2000-12-05T16:30:20.000000300  (NO change)
        print(date1.atTime(LocalTime.of(16,30)));
        // print: 2000-12-05T16:30  (NO change)

        print(date1.getDayOfWeek());                  // print: TUESDAY
        print(date1.getDayOfMonth());                 // print: 5
        print(date1.getDayOfWeek());                  // print: TUESDAY
        print(date1.getMonth());                      // print: DECEMBER
        print(date1.getMonthValue());                 // print: 12
        print(date1.getYear());                       // print: 2000

        print(date1.toEpochDay());             // print: 11296 (days from 01.01.1970)
        }}
