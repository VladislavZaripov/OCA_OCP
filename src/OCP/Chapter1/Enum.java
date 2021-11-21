package OCP.Chapter1;
public class Enum{
    interface inner{}

    public enum Season implements inner {                  // don't extend enums or class
        WINTER(10){
            public void printHourse() {System.out.println("9am-3pm");}
        },
        SPRING(20){
            public void printHourse() {System.out.println("9am-5pm");}
            public void printopinion() {System.out.println("Not bad");}
        },
        SUMMER(30){
            public void printHourse() {System.out.println("9am-7pm");}
            public void printopinion() {System.out.println("Good");}
        },
        FALL(40){
            public void printHourse() {System.out.println("9am-5pm");}
        };                                 // semicolon optional if there are only values

        int id;
        Season (int id){this.id = id;}                     // constructor is only private

        public void printIDseason(){System.out.println(id); }
        public abstract void printHourse();
        public void printopinion() {System.out.println("Fucking " + this);}
    }

    public static void main(String[] args) {
        Season s1 = Season.WINTER;
        Season s2 = Season.valueOf("WINTER");
    //  Season s3 = Season.valueOf("winter");            // IllegalArgumentException

        System.out.println(Season.WINTER);                              // WINTER
        System.out.println(s1 == Season.WINTER);                        // true
        s1.printIDseason();                                             // 10
        s1.printHourse();                                               // 9am-3pm
        s1.printopinion();                                              // Fucking WINTER

        for (Season season : Season.values())
            System.out.print(season.name() + " " + season.ordinal() + " ");
            // WINTER 0 SPRING 1 SUMMER 2 FALL 3

        switch (s1){
            case WINTER:
            case FALL:
            default: }
    }}
