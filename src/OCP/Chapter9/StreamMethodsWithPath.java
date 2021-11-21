package OCP.Chapter9;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;
public class StreamMethodsWithPath {}
/*****************************************************************************************/
/* walk () */
class StreamMethods1 {
    public static void main(String[] args) {
        Path path = Paths.get("/one");
        try{
            Files.walk(path).filter((x) ->x.toString().endsWith(".java")).
                                                        forEach(System.out::println);
        }       // can print: /one/two/file.java  ,  /one/file1.java  , and etc.
        catch (IOException e) {}
        // walk(Path, int) - int is maximum directory depth. Current directory is 0.
        // walk don't travers the symbolic link cause of infinite circular searching.
        // For travers symbolic link use FOLLOW_LINKS.
        // Travers the path in lazy manner. Set elements build and read while traversing.
        // "Lazy" - don't overflow memory. Store small portion in memory it time.
    }}
/*****************************************************************************************/
/* find () */
class StreamMethods2 {
    public static void main(String[] args) {
        Path path = Paths.get("/one");
        long dataFilter = 1420070400000l;
        try{
            Stream <Path> stream = Files.find (path,10, (p,a) ->
            p.toString().endsWith("java") && a.lastModifiedTime().toMillis()>dataFilter);

            stream.forEach(System.out :: println); }
        catch (IOException e) {}
        // find (path, int maxDepth, BiPredicate (Path, BasicFileAttributes) )
        // For travers symbolic link use FOLLOW_LINKS.
    }}
/*****************************************************************************************/
/* list () */
class StreamMethods3 {
    public static void main(String[] args) {
        Path path = Paths.get("two"); // assume that full path is /one/two
        try {
            Files.list(path).filter(p -> !Files.isDirectory(p)).
                    map(p -> p.toAbsolutePath()).forEach(System.out::println);
        }       // can print: /one/two/file.txt  ,  /one/two/file1.txt  , and etc.
        catch (IOException e) {}
    }}
/*****************************************************************************************/
/* lines () */ // PRINTING FILE CONTENT
class StreamMethods4 {
    public static void main(String[] args) {
        Path path = Paths.get("/one/file.log");
        /* Content of file */
        // INFO Server starting
        // DEBUG Processes available = 10
        // WARN No database could be detected
        // DEBUG Processes available reset to 0
        // WARN Performing manual recovery
        // INFO Server successfully started
        try {

            Files.lines(path).forEach(System.out::println);
            // print all content

            System.out.println( Files.lines(path).filter(p -> p.startsWith("WARN")).
                    map(p -> p.substring(5)).collect(Collectors.toList()));
            // print [No database could be detected, Performing manual recovery]
        }
        catch (IOException e) {}
        // Line is "Lazy".
    }}


