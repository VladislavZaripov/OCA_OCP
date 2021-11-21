package OCP.Chapter5;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class DatesAndTimes {
    public static void main(String[] args) {
        LocalDate.now();        // 2019-11-16
        LocalTime.now();        // 20:51:40.053
        LocalDateTime.now();    // 2019-11-16T20:51:40.053
        ZonedDateTime.now();    // 2019-11-16T20:51:40.053+03:00[Europe/Moscow]

        /*Finding a Time Zone*/
        ZoneId.getAvailableZoneIds().stream().filter(z->z.contains("Moscow")).
                sorted().forEach(System.out::println);          // Europe/Moscow

        /*Creating ZonedDateTime*/
        LocalDate date = LocalDate.of(2019,11,16);
        LocalTime time = LocalTime.of(20,54,30,20000);
        LocalDateTime dateTime = LocalDateTime.of(2019,11,16,20,54,30,20000);
        ZoneId zone = ZoneId.of("Europe/Moscow");

        ZonedDateTime zdt1 = ZonedDateTime.of(2019,11,16,20,54,30,20000,zone);
        ZonedDateTime zdt2 = ZonedDateTime.of(date,time,zone);
        ZonedDateTime zdt3 = ZonedDateTime.of(dateTime,zone);

        /*Period*/
        Period annually = Period.ofYears(1);                // P1Y
        Period quarterly = Period.ofMonths(3);              // P3M
        Period everyThreeWeeks = Period.ofWeeks(3);         // P21D
        Period everyOtherDay = Period.ofDays(2);            // P2D
        Period everyYearAndAWeek = Period.of(1, 0, 7);      // P1Y7D

        LocalDate date1 = date.plus(annually).plus(quarterly);
        LocalDateTime dateTime1 = dateTime.minus(annually);

        /*Duration*/
        Duration daily = Duration.ofDays(1);                // PT24H
        Duration hourly = Duration.ofHours(1);              // PT1H
        Duration everyMinute = Duration.ofMinutes(1);       // PT1M
        Duration everyTenSeconds = Duration.ofSeconds(10);  // PT10S
        Duration everyMilli = Duration.ofMillis(1);         // PT0.001S
        Duration everyNano = Duration.ofNanos(1);           // PT0.000000001S

        LocalTime time1 = time.plus(daily);
        LocalDateTime dateTime2 = dateTime.minus(hourly);

        // another way of creation
        Duration daily1 = Duration.of(1, ChronoUnit.DAYS);
        Duration hourly1 = Duration.of(1, ChronoUnit.HOURS);
        Duration everyMinute1 = Duration.of(1, ChronoUnit.MINUTES);
        Duration everyTenSeconds1 = Duration.of(10, ChronoUnit.SECONDS);
        Duration everyMilli1 = Duration.of(1, ChronoUnit.MILLIS);
        Duration everyNano1 = Duration.of(1, ChronoUnit.NANOS);

        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        System.out.println(ChronoUnit.HOURS.between(one, two));     // 1
        System.out.println(ChronoUnit.MINUTES.between(one, two));   // 75

        /*Instant*/
        ZonedDateTime zdt4 = ZonedDateTime.of(dateTime,zone);
        Instant instant = zdt4.toInstant();
        System.out.println(zdt4);     // 2019-11-16T20:54:30.000020+03:00[Europe/Moscow]
        System.out.println(instant);  // 2019-11-16T17:54:30.000020Z

        /*Daylight Saving Time*/
        LocalDate dateM= LocalDate.of(2016, Month.MARCH, 13);
        LocalTime timeM = LocalTime.of(1, 30);
        ZoneId zoneM = ZoneId.of("US/Eastern");
        ZonedDateTime dateTimeM = ZonedDateTime.of(dateM, timeM, zoneM);
        System.out.println(dateTimeM); // 2016–03–13T01:30–05:00[US/Eastern]
        dateTimeM = dateTimeM.plusHours(1);
        System.out.println(dateTimeM); // 2016–03–13T03:30–04:00[US/Eastern]

        LocalDate dateN = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime timeN = LocalTime.of(1, 30);
        ZoneId zoneN = ZoneId.of("US/Eastern");
        ZonedDateTime dateTimeN = ZonedDateTime.of(dateN, timeN, zoneN);
        System.out.println(dateTimeN); // 2016–11–06T01:30–04:00[US/Eastern]
        dateTimeN = dateTimeN.plusHours(1);
        System.out.println(dateTimeN); // 2016–11–06T01:30–05:00[US/Eastern]
    }}
