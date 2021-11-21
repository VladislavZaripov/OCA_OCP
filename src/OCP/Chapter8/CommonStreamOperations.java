package OCP.Chapter8;
import java.io.*;
public class CommonStreamOperations {
    public static void main(String[] args) throws Exception{

/* close () - Closing the stream */
        FileReader reader = new FileReader("C:\\Users\\Танюшка\\Desktop\\Sample\\file1.txt");
        System.out.println((char)reader.read());        // R
        reader.close();

/* flush () - Flushing the Stream */
        FileOutputStream writer =
                new FileOutputStream("C:\\Users\\Танюшка\\Desktop\\Sample\\file2.txt");
        writer.write(reader.read());  // before writing, data can catch in memory.
        writer.flush();    // avoid data lost when program terminates unexpectedly.

/* mark () , reset () - Marking the Stream */
        BufferedInputStream is = new BufferedInputStream
                (new FileInputStream("C:\\Users\\Танюшка\\Desktop\\Sample\\file3.txt")); // 12345
        System.out.println((char)is.read());        // 1
        if (is.markSupported()) {
            is.mark(100);   // if read limit is passed, reading may throw exception (only may).
            System.out.println((char)is.read());    // 2
            System.out.println((char)is.read());    // 3
            is.reset();         }
        System.out.println((char)is.read());        // 2
        System.out.println((char)is.read());        // 3

/* skip () - Skipping over Data */
        FileInputStream fis =
                new FileInputStream("C:\\Users\\Танюшка\\Desktop\\Sample\\file3.txt");
        System.out.println((char)fis.read());        // 1
        fis.skip(2);
        System.out.println((char)fis.read());        // 4
    }}
