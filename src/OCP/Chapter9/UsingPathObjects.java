package OCP.Chapter9;
import java.nio.file.*;
public class UsingPathObjects {}

/*****************************************************************************************/
/* toString() , getNameCount () , getName (int) */
class PathMethods1 {
    public static void main(String[] args) {
        Path path = Paths.get("C://land//hippo/harry.happy");
        System.out.println("The path name is: " + path);
        for (int i = 0; i<path.getNameCount(); i++){
            System.out.println("Element " + i + " is: " + path.getName(i));}
                // The path name is: C:\land\hippo\harry.happy
                // Element 0 is: land
                // Element 1 is: hippo
                // Element 2 is: harry.happy
                // Root element is not included
    }}

/*****************************************************************************************/
/* getFileName() , getParent () , getRoot () */
class PathMethods2 {
    public static void main(String[] args) {
        Path path1 = Paths.get("C://land//hippo/harry.happy");  // absolute path
        System.out.println(path1.getFileName());                // harry.happy
        System.out.println(path1.getRoot());                    // C:\
        Path currentParent = path1;
        while ( ( currentParent = currentParent.getParent() )!= null)  {
            System.out.println("Current Parent is: " + currentParent); }
                // Current Parent is: C:\land\hippo
                // Current Parent is: C:\land
                // Current Parent is: C:\

        Path path2 = Paths.get("land//hippo/harry.happy");      // relative path
        System.out.println(path2.getFileName());                // harry.happy
        System.out.println(path2.getRoot());                    // null
        currentParent = path2;
        while ( ( currentParent = currentParent.getParent() )!= null)  {
            System.out.println("Current Parent is: " + currentParent); }
                // Current Parent is: land\hippo
                // Current Parent is: land
    }}

/*****************************************************************************************/
/* isAbsolute () , toAbsolutePath () */
class PathMethods3 {
    public static void main(String[] args) {
        Path path1 = Paths.get("c://one/file.txt");
        System.out.println(path1.isAbsolute());     // true (for Mac or Linux output false)
        System.out.println(path1.toAbsolutePath()); // c:\one\file.txt

        Path path2 = Paths.get("/home/file.txt");
        System.out.println(path2.isAbsolute());     // false (for Mac or Linux output true)
        System.out.println(path2.toAbsolutePath()); // C:\home\file.txt
    }}

/*****************************************************************************************/
/* subpath () */
class PathMethods4 {
    public static void main(String[] args) {
        Path path = Paths.get("c://one/two/file.txt");
        System.out.println(path.subpath(0,3));      // one\two\file.txt
        System.out.println(path.subpath(1,2));      // two
    //  System.out.println(path.subpath(1,1));      // throw IllegalArgumentException
    //  System.out.println(path.subpath(1,4));      // throw IllegalArgumentException
    }}

/*****************************************************************************************/
/* Using PAth Symbols */

//   .   -  A reference to the current directory
//   ..  -  A reference to the parent of the current directory

// Examples

// ../file.txt - refers to file.txt in the parent directory
//  ./file.txt - refers to file.txt in the current directory
// ../../file.txt - refers to file.txt that is two directory up from the current directory

/*****************************************************************************************/
/* relativize () */
class PathMethods5 {
    public static void main(String[] args) {
        Path path1 = Paths.get("one/file1.txt");        // use relative path with relative
        Path path2 = Paths.get("file2.txt");
        System.out.println(path1.relativize(path2));    // ..\..\file2.txt
        System.out.println(path2.relativize(path1));    // ..\one\file1.txt

        Path path3 = Paths.get("C://one/file1.txt");    // use absolute path with absolute
        Path path4 = Paths.get("C://file2.txt");
        System.out.println(path3.relativize(path4));    // ..\..\file2.txt
        System.out.println(path4.relativize(path3));    // ..\one\file1.txt

        Path path5 = Paths.get("C://one/file1.txt");    // different root
        Path path6 = Paths.get("/file2.txt");           // throw IllegalArgumentException

        Path path7 = Paths.get("C://one/file1.txt");    // different root
        Path path8 = Paths.get("D://file2.txt");        // throw IllegalArgumentException

        Path path9 = Paths.get("C://one/file1.txt");    // relative and absolute
        Path path0 = Paths.get("file2.txt");            // throw IllegalArgumentException
    }}

/*****************************************************************************************/
/* resolve () */
class PathMethods6 {
    public static void main(String[] args) {
        Path path1 = Paths.get("one/file1.txt");        // relative
        Path path2 = Paths.get("two/file2.txt");        // relative
        System.out.println(path1.resolve(path2));       // one\file1.txt\two\file2.txt
        System.out.println(path2.resolve(path1));       // two\file2.txt\one\file1.txt

        Path path3 = Paths.get("C://one/file1.txt");    // absolute
        Path path4 = Paths.get("C://two/file2.txt");    // absolute
        System.out.println(path3.resolve(path4));       // C:\two\file2.txt
        System.out.println(path4.resolve(path3));       // C:\one\file1.txt

        Path path5 = Paths.get("C://one/file1.txt");    // absolute
        Path path6 = Paths.get("two/file2.txt");        // relative
        System.out.println(path5.resolve(path6));       // C:\one\file1.txt\two\file2.txt
        System.out.println(path6.resolve(path5));       // C:\one\file1.txt

        Path path7 = Paths.get("one/../file1.txt");     // relative
        Path path8 = Paths.get("two/..");               // relative
        System.out.println(path7.resolve(path8));       // one\..\file1.txt\two\..
        System.out.println(path8.resolve(path7));       // two\..\one\..\file1.txt
    }}

/*****************************************************************************************/
/* normalize () */
class PathMethods7 {
    public static void main(String[] args) {
        Path path1 = Paths.get("C://one");              // absolute
        Path path2 = Paths.get("C://two/three");        // absolute

        Path relativePath = path1.relativize(path2);
        System.out.println(relativePath);               // ..\two\three
        System.out.println(path1.resolve(relativePath));            // C:\one\..\two\three
        System.out.println(path1.resolve(relativePath).normalize());   // C:\two\three
    }}

/*****************************************************************************************/
/* toRealPath ()   Checking the file existence. Support the NOFOLLOW_LINKS
        Example:
        We have file system in which we have symbolic linc from -> to
        /zebra/food.source -> /horse/food.txt
        Assuming that our current directory /horse/schedule
try { System.out.println(Paths.get("/zebra/food.source").toRealPath());  // /horse/food.txt
      System.out.println(Paths.get(".././food.txt").toRealPath());       // /horse/food.txt
    } catch (IOException e) {}
*/
