package OCA.DatesAndTimes;                                /* Period is immutable */

        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.Period;
        public class PeriodClass {
        static void print (Period x)   {System.out.println(x);}
        static void print (LocalDate x)   {System.out.println(x);}
        static void print (LocalDateTime x)   {System.out.println(x);}
        static void print (long x)   {System.out.println(x);}
        static void print (boolean x)   {System.out.println(x);}
        public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2010,5,10);
        LocalDate date2 = LocalDate.of(2000,5,5);
        LocalDateTime ldt1 = LocalDateTime.parse("2015-10-15T10:10:10");

        Period period1 = Period.ofDays(-40);                        // print: P-40D
        Period period2 = Period.ofWeeks(10);                        // print: P70D
        Period period3 = Period.ofMonths(-20);                      // print: P-20M
        Period period4 = Period.ofYears(10);                        // print: P10Y
        Period period5 = Period.of(10,10,10);   // print: P10Y10M10D
        // PnYnMnD (pnynmnd) or PnW (pnw)  // n - number // can assign "-"
        // P,p - parse // Y,y - Year // M,m - Month // D,d - Day // W,w - Week
        // W,w - Week // 1 week = 7 days
        Period period6 = Period.parse("-P+5Y-5M5D");                // print: P-5Y5M-5D
        Period period7 = Period.parse("P-5W");                      // print: P-35D
        Period period8 = Period.between(date1,date2);               // print: P-10Y-5D

        print(period5.plus(period1));                               // print: P10Y10M-30D
        print(period2.plusDays(-20));                               // print: P50D
        print(period2.plusMonths(10));                              // print: P10M70D
        print(period4.plusYears(-10));                              // print: P0D
        print(period5.minus(period5));                              // print: P0D
        print(period2.minusDays(-5));                               // print: P75D
        print(period5.minusMonths(-20));                            // print: P10Y30M10D
        print(period1.minusYears(1));                               // print: P-1Y-40D

        print(period2.multipliedBy(-5));                            // print: P-350D

        print(date1.plus(period5));                                 // print: 2021-03-20
        print(ldt1.minus(period2));                         // print: 2015-08-06T10:10:10

        print(period5.getDays());                                   // print: 10
        print(period5.getMonths());                                 // print: 10
        print(period5.getYears());                                  // print: 10

        print(Period.parse("P5Y-5M").isNegative());                 // print: true
        print(Period.parse("P5Y5M").isNegative());                  // print: false

        print(Period.parse("P5Y+5D").isZero());                     // print: false
        print(Period.parse("P0Y+0M-0D").isZero());                  // print: true

        print(Period.parse("P-5Y+30M+20D").toTotalMonths());        // print: -30
        }}
