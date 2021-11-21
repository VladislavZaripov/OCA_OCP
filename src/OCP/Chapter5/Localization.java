package OCP.Chapter5;
import java.util.Locale;

public class Localization {
    public static void main(String[] args) {

    // Create Local
        Locale l1 = new Locale("hi","IN");
        Locale l2 = new Locale.Builder().setLanguage("de").setRegion("DE").build();
        Locale l3 = new Locale.Builder().setRegion("RU").setLanguage("ru").build();
        System.out.println(Locale.GERMAN);      // de
        System.out.println(Locale.GERMANY);     // de_DE

    // Set new Default Local for program
        Locale l4 = Locale.getDefault();
        System.out.println(l4);                     // ru_RU
        Locale.setDefault(l1);
        System.out.println(Locale.getDefault());    // hi_IN
        Locale.setDefault(l3);
    }
}
