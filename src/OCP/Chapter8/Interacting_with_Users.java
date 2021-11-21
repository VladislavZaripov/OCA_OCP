package OCP.Chapter8;
import java.io.*;
import java.util.Arrays;
public class Interacting_with_Users {}

/*****************************************************************************************/
class The_Old_Way {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        System.out.println("You just print: " + string);
    }}

/*****************************************************************************************/
/* java.io.Console */
    // Singleton class. System.console() return null in IDEA. It must be used in program.
class Console_Class_And_Methods {
    public static void main(String[] args) {
        Console console = System.console();

/* reader () and writer () */
        if (console != null) {
            String string = console.readLine();
            console.writer().println ("You just print: " + string); }

/* format () and printf () */
    // look class Create_Properties_File_Bundle Chapter5
    // Locale l1 = new Locale("hi","IN");
    // console.writer().format(l1,"Hello");
    // console.writer().format(new Locale("fr","CA"),"Hello");

/* flush () */
    // Forces any buffered output to be written immediately.

/* readLine () */
        if (console != null) {
            String string1 = console.readLine();
            console.writer().println ("You just print: " + string1);
            String string2 = console.readLine("Please enter something: ");
            console.writer().println ("You just print: " + string2); }

/* readPassword () */
    // User does not see the text he is typing.
    // It's return a Character Array for except to save the password in String pool.
        if (console != null) {
            char[] password = console.readPassword ("Enter your password: ");
            console.format("Enter your password again: ");
            console.flush();
            char [] verify = console.readPassword();
            boolean match = Arrays.equals(password, verify);
            // immediately clean password from memory
            for (int i = 0; i < password.length; i++) password [i] = 'x';
            for (int i = 0; i < verify.length; i++) password [i] = 'x';
            console.format("Your password was " + (match? "correct" : "incorrect"));
        }}}
