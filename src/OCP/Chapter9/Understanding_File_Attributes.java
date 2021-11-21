package OCP.Chapter9;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
public class Understanding_File_Attributes {}

/*****************************************************************************************/
/* isDirectory () , isRegularFile () , isSymbolicLink () */
class AttributesMethods1 {
    public static void main(String[] args) {
        Files.isDirectory    (Paths.get("/one/two"));       // true
        Files.isRegularFile  (Paths.get("/one/file.txt"));  // true
        Files.isSymbolicLink (Paths.get("/Numbers"));       // true if it is link
        // Do not throw Exception
    }}

/*****************************************************************************************/
/* isHidden () */
class AttributesMethods2 {
    public static void main(String[] args) {
        try{
            System.out.println(Files.isHidden(Paths.get("one/file.txt")));
        }
        catch (IOException e) {}
    }}

/*****************************************************************************************/
/* isReadable () , isExecutable () */
class AttributesMethods3 {
    public static void main(String[] args) {
        System.out.println(Files.isReadable(Paths.get("one/file.txt")));
        System.out.println(Files.isExecutable(Paths.get("one/file.txt")));
        // Do not throw Exception. Return false if file does not exist.
        // Methods check user's access for reading or executing file.
    }}

/*****************************************************************************************/
/* size () */
class AttributesMethods4 {
    public static void main(String[] args) {
        try{
            Long sizeInBytes = Files.size(Paths.get("one/file.txt"));
            // Working only with file. Return Long.
        }
        catch (IOException e) {}
    }}

/*****************************************************************************************/
/* getLastModifiedTime () , setLastModifiedTime () */
class AttributesMethods5 {
    public static void main(String[] args) {
        try{
            Path path = Paths.get("/one/file.txt");
            Long millis = Files.getLastModifiedTime(path).toMillis();
            FileTime time = Files.getLastModifiedTime(path);
          Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
            // Determines when file was accessed, changed or created.
            // Throw Exception when file is accessed or modified by user in this time.
        }
        catch (IOException e) {}
    }}

/*****************************************************************************************/
/* getOwner () , setOwner () */
class AttributesMethods6 {
    public static void main(String[] args) {
        try{
            // Read owner of file
            Path path = Paths.get("/onefile.txt");
            System.out.println(Files.getOwner(path));
            // Change owner of file
            UserPrincipal user = path.getFileSystem().getUserPrincipalLookupService().
                                                        lookupPrincipalByName("Vlad");
            Files.setOwner(path,user);
            // Throw Exception in case of any issues accessing or modifying the file.
        }
        catch (IOException e) {}
    }}

/*****************************************************************************************/
/* BasicFileAttributes class  and BasicFileAttributeView class*/
class AttributesMethods7 {
    public static void main(String[] args) {
        try{
            Path path = Paths.get("/onefile.txt");
            // readAttributes - method return read-only version of a file view.
            // getFileAttributeView - method return modified version of a file view.
            // You can modified only several attributes. You can't modified size and etc.
BasicFileAttributeView view = Files.getFileAttributeView(path,BasicFileAttributeView.class);
BasicFileAttributes data = Files.readAttributes(path,BasicFileAttributes.class);
            // or BasicFileAttributes data = view.readAttributes();

            System.out.println("Is path a directory? "+data.isDirectory());
            System.out.println("Is path a regular file? "+data.isRegularFile());
            System.out.println("Is path a symbolic link? "+data.isSymbolicLink());
            System.out.println("Path not a file, directory, nor link? "+ data.isOther());
            System.out.println("Size (in bytes): "+data.size());
            System.out.println("Creation date/time: "+data.creationTime());
            System.out.println("Last modified date/time: "+data.lastModifiedTime());
            System.out.println("Last accessed date/time: "+data.lastAccessTime());
            System.out.println("Unique file identifier (if available): "+ data.fileKey());

FileTime lastModifiedTime = FileTime.fromMillis(data.lastModifiedTime().toMillis() + 10_000);
view.setTimes(lastModifiedTime,null,null);
            // setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime)
            // If you don't want to change time, you have to pass null.
     }
        catch (IOException e) {}
    }}      // Throw UnsupportedOperationException when class type is unsupported.
