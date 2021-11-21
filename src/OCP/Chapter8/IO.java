package OCP.Chapter8;
import java.io.*;
import java.util.*;
public class IO {}

/*****************************************************************************************/
class FileInputStream_And_FileOutputStream {
    static void copy (File a , File b) throws IOException {
        try ( InputStream  in  = new FileInputStream(a);
              OutputStream out = new FileOutputStream(b) )
        {int x; while ( ( x = in.read() )!= -1) out.write(x);}
    }
    public static void main(String[] args) throws Exception{
        File f1= new File("C:\\Users\\Танюшка\\Desktop\\Sample\\is.txt");
        File f2= new File("C:\\Users\\Танюшка\\Desktop\\Sample\\os.txt");
        copy (f1,f2);
    }}

/*****************************************************************************************/
class BufferedInputStream_And_BufferedOutputStream {
    static void copy (File a , File b) throws IOException {
        try ( InputStream in   = new BufferedInputStream  (new FileInputStream (a) );
              OutputStream out = new BufferedOutputStream (new FileOutputStream(b) ) )
        { byte [] buffer = new byte[1024];     int lengthRead;
             while ((lengthRead = in.read(buffer)) > 0)
                { out.write(buffer,0,lengthRead); out.flush(); }  }
    }
    public static void main(String[] args) throws Exception{
        File f1= new File("C:\\Users\\Танюшка\\Desktop\\Sample\\is.txt");
        File f2= new File("C:\\Users\\Танюшка\\Desktop\\Sample\\os.txt");
        copy (f1,f2);
    }}

/*****************************************************************************************/
class BufferedReader_And_BufferedWriter {
    static List<String> readFile (File a) throws IOException {
        List <String> data = new ArrayList<>();
        try ( BufferedReader in = new BufferedReader (new FileReader(a)) )
            { String s; while ( (s = in.readLine()) != null ) data.add(s); }
        return data;
    }
    static void copyFile (List <String> data, File b) throws IOException{
        try ( BufferedWriter out = new BufferedWriter(new FileWriter(b)) )
            { for (String st : data) { out.write(st); out.newLine(); }   }
    }
    public static void main(String[] args) throws IOException{
        File f1= new File("C:\\Users\\Танюшка\\Desktop\\Sample\\is.txt");
        File f2= new File("C:\\Users\\Танюшка\\Desktop\\Sample\\os.txt");
        List <String> data;
        data = readFile(f1);
        for (String st : data) System.out.println(st);
        copyFile(data,f2);
    }}

/*****************************************************************************************/
class SomeObject implements Serializable {
    private static final long serialVersionUID = 1l;
    private String name;
    private int num;
    private transient String no;
    private static char sc = 'c';
    public SomeObject (String name, int num, String noname, char sc )  {
        this.name = name;  this.num  = num;  this.no = noname; this.sc = sc;}
    public SomeObject ()  {
        this.name = "Unknown";  this.num  = 10;  this.no = "No"; this.sc ='z';}
    @Override public String toString() { return  "name: " + this.name + " | num: "
            + this.num + " | no: " + this.no + " | sc: " + sc; }
}
class ObjectInputStream_And_ObjectOutputStream {
    /* Serialization */
    public static List <SomeObject> getObjects (File a) throws IOException,
                                                               ClassNotFoundException {
        List <SomeObject> data = new ArrayList<>();
        try ( ObjectInputStream in = new ObjectInputStream (
                                     new BufferedInputStream (new FileInputStream (a))) )
        { while (true) { Object object = in.readObject();
          if (object instanceof SomeObject) data.add((SomeObject) object);} }
        catch (EOFException e) { /* File end reached */ }
     return data;
    }
    /* Deserialization */ // constructor and any default constructors are ignored
    public static void creatFile (List <SomeObject> list, File b) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream (
                                      new BufferedOutputStream( new FileOutputStream(b))) )
        {for (SomeObject object : list) out.writeObject(object);}
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List <SomeObject> objects = new ArrayList<>();
        objects.add(new SomeObject("one",1,"noone",'o'));
        objects.add(new SomeObject("two",2,"notwo",'v'));
        File dataFile = new File("SomeObject.data");
        creatFile(objects,dataFile);
        System.out.println(getObjects(dataFile));
        // [name: one | num: 1 | no: null | sc: v, name: two | num: 2 | no: null | sc: v]
    }}

/*****************************************************************************************/
class PrintStream_And_PrintWriter_Methods {
    public static void main(String[] args) throws FileNotFoundException{
/* print () */
    PrintWriter out1 = new PrintWriter("print1.log");
    out1.print(5);                  // do't write 5 in file print1.log. PrintWriter method.
    out1.write(String.valueOf(5));  // do't write 5 in file print1.log. Write method.

    PrintStream out2 = new PrintStream("print2.log");
    out2.print(5);                  // write 5 in file print2.log

/* println () */
// It,is new line, also you can use line separator '\n', but it is not recommended
        System.out.println("first line\nsecond line");

/* format () and printf ()*/
// the same methods for format String
// public PrintWriter format (String format, Object args...)
// public PrintWriter printf (String format, Object args...)
    }}
class PrintWriter_Sample_{      // write in file print3.log
    public static void main(String[] args) throws IOException{
        File a = new File("print3.log");
        try ( PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter(a))) )
        {
            out.print("one");
            out.println("two");     // new line after "two"
            out.format("three");
            out.printf("four");
        }}}
