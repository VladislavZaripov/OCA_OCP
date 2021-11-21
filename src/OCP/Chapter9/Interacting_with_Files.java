package OCP.Chapter9;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;
public class Interacting_with_Files {}

/*****************************************************************************************/
/* exists () */
class FilesMethods1 {
    public static void main(String[] args) {
        System.out.println(Files.exists(Paths.get("/one/file.txt")));       // false
        System.out.println(Files.exists(Paths.get("/one")));                // false
    }}

/*****************************************************************************************/
/* isSameFile () */
class FilesMethods2 {
    public static void main(String[] args) {
        try {
            System.out.println(Files.isSameFile(Paths.get("/one/two/../file.txt"),
                                                Paths.get("/one/file.txt")));       // true

            System.out.println(Files.isSameFile(Paths.get("/one/./file.txt"),
                                                Paths.get("/one/file.txt")));       // true

            System.out.println(Files.isSameFile(Paths.get("/one/file.txt"),
                                                Paths.get("/two/file.txt")));       // false
        }
        catch (IOException e) {System.out.println("File/Directory is not exist");}
    }}

/*****************************************************************************************/
/* createDirectory () , createDirectories () */
class FilesMethods3 {
    public static void main(String[] args) {
        try {
            System.out.println (Files.createDirectory (Paths.get("/home/one")));
            // create directory /one in /home
            System.out.println (Files.createDirectories (Paths.get("/home/one/two")));
            // create directory /one and /one/two in /home
        }
        catch (IOException e) {System.out.println("File/Directory is not exist");}
    }}

/*****************************************************************************************/
/* copy () */
class FilesMethods4 {
    public static void main(String[] args) {
        try {
            Files.copy (Paths.get("/one"),Paths.get("/two"));
            // Copy directory /one in /two. Do not copy content in directory /one.
            Files.copy (Paths.get("/one/file.txt"),Paths.get("/two/file.txt"));
            // Copy file. Do not overwrite.
            // Providing NOFOLLOW_LINKS , REPLACE_EXISTING , COPY_ATTRIBUTES
        }catch (IOException e) {System.out.println("File/Directory is not exist");}

        try (InputStream  is  = new FileInputStream ("source-data.txt");
             OutputStream out = new FileOutputStream("output-data.txt")  )
        { Files.copy(is, Paths.get("/one/file.txt"));    // copy stream to file
          Files.copy(Paths.get("/two/file.txt"), out); } // copy file to stream
        catch (IOException e) {System.out.println("File/Directory is not exist");}
    }}

/*****************************************************************************************/
/* move () */  // Move or rename file or directory
class FilesMethods5 {
    public static void main(String[] args) {
        try {
            Files.move (Paths.get("/one"),Paths.get("/two"));
            // Rename one to two. Keep all content.
            Files.move (Paths.get("/one/file.txt"),Paths.get("/two/file.txt"));
            // Move file.txt and rename it to file1.txt.
            // Providing NOFOLLOW_LINKS , REPLACE_EXISTING , ATOMIC_MOVE
        }   // Method can move a non-empty directory only in the same underlying drive.
            // Otherwise it will throw NIO.2.DirectoryNotEmptyException
        catch (IOException e) {System.out.println("File/Directory is not exist");}
    }}

/*****************************************************************************************/
/* delete () , deleteIfExist () */
class FilesMethods6 {
    public static void main(String[] args) {
        try {
            Files.delete (Paths.get("/one"));
            // If directory non-empty throw NIO.2.DirectoryNotEmptyException.
            // If target is symbol link, delete only link.
            Files.deleteIfExists (Paths.get("/one/file.txt"));
            // Will mot throw IOException if file or directory does not exist.
            // Instead it will return boolean false.
        }
        catch (IOException e) {System.out.println("File/Directory is not exist");}
    }}

/*****************************************************************************************/
/* newBufferedReader () , newBufferedWriter () */
class FilesMethods7 {
    public static void main(String[] args) {
        Path path = Paths.get("/one/file.txt");
        try (BufferedReader r = Files.newBufferedReader(path, Charset.forName("US-ASCII")))
        {
        String line = null;
        while ((line = r.readLine()) != null) System.out.println(line);
        }
        catch (IOException e) {System.out.println("File/Directory is not exist");}

        Path path1 = Paths.get("/one/file.txt");
        try (BufferedWriter w = Files.newBufferedWriter(path1, Charset.forName("US-ASCII")))
        {
        w.write("Hello World");
        }
        catch (IOException e) {System.out.println("File/Directory is not exist");}
    }}

/*****************************************************************************************/
/* readAllLines () */
class FilesMethods8 {
    public static void main(String[] args) {
        Path path = Paths.get("/one/file.txt");
        try {
            List <String> text = Files.readAllLines(path);
            // Storing all in memory at once. If file large, can throw OutOfMemoryError.
        }
        catch (IOException e) {System.out.println("File/Directory is not exist");}
    }}


