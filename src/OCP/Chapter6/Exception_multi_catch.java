package OCP.Chapter6;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class Exception_multi_catch {
    public static void main(String[] args) {
        try{
            Path path = Paths.get("some.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.of(21,11,2019);
            System.out.println(date);
        }
        catch (DateTimeParseException | IOException e ){
            e.printStackTrace();
            throw new RuntimeException();              }

    //  catch (Exception1 e  | Exception2 e  | Exception3 e)    // Does not compile
    //  catch (Exception1 e1 | Exception2 e2 | Exception3 e3)   // Does not compile
    //  catch (SUBCLASS Exception1 e1 | Exception2 e2)          // Does not compile

    //  try                 { do some work )
    //  catch (Exception e) {e = new RuntimeException ()}               // It is ok

    //  try                 { do some work )
    //  catch (Exception1 | Exception2 e) {e = new RuntimeException ()}
                              //  Does not compile, multi-catch is Effectively Final
}}
