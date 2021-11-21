package OCA.DatesAndTimes;

import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.LocalTime;
        import java.time.format.DateTimeFormatter;
        import java.time.format.FormatStyle;
        import java.util.Locale;
        import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
        public class DateTimeFormatterClass {
        static void print (String x) {System.out.println(x);}
        public static void main(String[] args) {

        LocalDate date = LocalDate.parse("2015-10-10");
        LocalTime time = LocalTime.parse("10:10:10");
        LocalDateTime datetime = date.atTime(time);

        DateTimeFormatter d1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter d2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter d3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter d4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        print(date.format(d1));                 // print: 10.10.15
        print(date.format(d2));                 // print: 10.10.2015
        print(date.format(d3));                 // print: 10 октября 2015 г.
        print(date.format(d4));                 // print: 10 октября 2015 г.

        DateTimeFormatter t1 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter t2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        DateTimeFormatter t3 = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        DateTimeFormatter t4 = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);
        print(time.format(t1));                 // print: 10:10
        print(time.format(t2));                 // print: 10:10:10
        // print(time.format(t3));              DateTimeException
        // print(time.format(t4));              DateTimeException

        DateTimeFormatter dt1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dt2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter dt3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter dt4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);
        print(datetime.format(dt1));            // print: 10.10.15 10:10
        print(datetime.format(dt2));            // print: 10.10.2015 10:10:10
        // print(datetime.format(dt3));         DateTimeException
        print(datetime.format(dt4));            // print: 10 октября 2015 г. 10:10

        DateTimeFormatter p1 = BASIC_ISO_DATE; //without DateTimeFormatter if use import statement
        DateTimeFormatter p2 = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter p3 = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter p4 = DateTimeFormatter.ISO_TIME;
        DateTimeFormatter p5 = DateTimeFormatter.ISO_LOCAL_TIME;
        DateTimeFormatter p6 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter p7 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter p8 = DateTimeFormatter.ofPattern("yyyy-MMMM-dd",Locale.ENGLISH);
        DateTimeFormatter p9 = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        print(date.format(p1));                 // print: 20151010
        print(date.format(p2));                 // print: 2015-10-10
        print(date.format(p3));                 // print: 2015-10-10
        print(time.format(p4));                 // print: 10:10:10
        print(p5.format(time));                 // print: 10:10:10
        print(datetime.format(p6));             // print: 2015-10-10T10:10:10
        print(p7.format(datetime));             // print: 2015-10-10T10:10:10
        print(date.format(p8));                 // print: 2015-October-10
        print(p9.format(date));                 // print: 2015-окт-10

        LocalDate date2 = LocalDate.parse("2015-October-10",p8);  // print: 2015-10-10
        LocalDate date3 = LocalDate.parse("20151010",BASIC_ISO_DATE);
        }}
