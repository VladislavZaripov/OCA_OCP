package OCP.Chapter9;
import java.io.File;
import java.net.*;
import java.nio.file.*;
public class PathInterface {}

/*****************************************************************************************/
class CreatePath{
    public static void main(String[] args) throws URISyntaxException {
        Path path1 = Paths.get("pandas/cuddly.png");   // relative path
        Path path2 = Paths.get("C:\\employees.txt");   // absolute path for Windows
        Path path3 = Paths.get("/home/zoodirector");   // absolute path for Linux

        Path path4 = Paths.get("pandas","cuddly.png");
        Path path5 = Paths.get("C:","employees.txt");
        Path path6 = Paths.get("/","home","zoodirector");

        // You can create URL: file://  http://  https://  ftp:/ and another
        // URI - Uniform resource identifier. Throws URISyntaxException.
        // URI must reference absolute path at runtime. First example throw Exception.
        Path path7 = Paths.get(new URI("file://pandas/cuddly.png"));
        Path path8 = Paths.get(new URI("file:///C:/employees.txt"));
        Path path9 = Paths.get(new URI("file:///home/zoodirector"));

        System.out.println(path1.isAbsolute());         // false
        System.out.println(path2.isAbsolute());         // true

/* Accessing the Underlying FileSystem Object */
        Path path10 = FileSystems.getDefault().getPath("pandas/cuddly.png");
        Path path11 = FileSystems.getDefault().getPath("C:","employees.txt");
        Path path12 = FileSystems.getDefault().getPath("/home/zoodirector");

    //  FileSystem file = FileSystems.getFileSystem( new URI ("http://www.selikoff.net"));
    //  Path path13 = file.getPath("duck.txt");

/* Working with Legacy File Instances*/
        File file1 = new File("pandas/cuddly.png");
        Path path14 = file1.toPath();

        Path path15 = Paths.get("pandas/cuddly.png");
        File file2 = path15.toFile();
    }}
