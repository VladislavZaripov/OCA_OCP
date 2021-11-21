package OCP.Chapter5;
import java.io.*;
import java.util.*;
public class Create_Properties_File_Bundle{
    public static void PrintProperties (Locale locale){
        ResourceBundle rb = ResourceBundle.getBundle("text", locale);
        System.out.println(rb.getString("Hello"));

        Set <String> keys = rb.keySet();
        keys.stream().map(k->k + " " + rb.getString(k)).forEach(System.out::println);
    }

    public static void main(String[] args)  throws IOException {
// Creating a Property File Resource Bundle
        Properties properties1 = new Properties();
        properties1.setProperty("Hello","Здраствуйте");
        properties1.setProperty("One","Один");
        FileOutputStream out1 = new FileOutputStream("src\\text_ru.properties");
        properties1.store(out1,"coment1");

        Properties properties2 = new Properties();
        properties2.setProperty("Hello","Bonjour");
        properties2.setProperty("One","Un");
        FileOutputStream out2 = new FileOutputStream("src\\text_fr.properties");
        properties2.store(out2,"coment2");

// Use method for print Local variable
        Locale locale1 = new Locale("ru","RU"); // Здраствуйте
        PrintProperties(locale1);               // Hello Здраствуйте    // One Один

        Locale locale2 = new Locale("fr","FR"); // Bonjour
        PrintProperties(locale2);               // Hello Bonjour        // One Un

// Copy properties
        Properties properties3 = new Properties();
        ResourceBundle rb1 = ResourceBundle.getBundle("text", locale1);
        rb1.keySet().stream().forEach(k->properties3.put(k,rb1.getString(k)));

// Method getProperty
        System.out.println(properties3.getProperty("Hello"));           // Здраствуйте
        System.out.println(properties3.getProperty("Bye","Пока"));      // Пока
    }
}
