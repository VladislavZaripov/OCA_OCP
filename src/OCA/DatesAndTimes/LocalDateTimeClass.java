package OCA.DatesAndTimes;        /* LocalDateTime uses  methods LocalTime and LocalDate */

        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.time.LocalTime;
        public class LocalDateTimeClass {
        public static void main(String[] args) {
                LocalDate date = LocalDate.parse("2015-10-10");
                LocalTime time = LocalTime.parse("10:10:10");

        LocalDateTime ldt1 = LocalDateTime.parse("2050-06-05T10:10:10");
        LocalDateTime ldt2 = LocalDateTime.of(2050,11,
       10,10,10,10,300);
        LocalDateTime ldt3 = LocalDateTime.now();
        LocalDateTime ldt4 = date.atTime(time);
        LocalDateTime ldt5 = time.atDate(date);
        }}
