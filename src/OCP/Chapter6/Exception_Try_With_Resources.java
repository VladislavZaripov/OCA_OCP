package OCP.Chapter6;
import java.io.*;
import java.io.IOException;
import java.nio.file.*;
public class Exception_Try_With_Resources {

    public void readwrite (Path path1, Path path2) throws IOException {
        try (BufferedReader in  = Files.newBufferedReader(path1);
             BufferedWriter out = Files.newBufferedWriter(path2)   )

        { out.write(in.readLine());}

        //  <- at this point resource are closed (in.close() / out.close())

        catch (Exception e) {}

        finally             {}
}}
