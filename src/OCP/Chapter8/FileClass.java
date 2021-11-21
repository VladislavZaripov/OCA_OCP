package OCP.Chapter8;
import java.io.File;
public class FileClass {
    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\Танюшка\\Desktop\\Sample\\text.txt");
        File file2 = new File("C:\\Users\\Танюшка\\Desktop\\Sample\\text2.txt");

        System.out.println("exist:" + file1.exists());                 // true
        System.out.println("name:"  + file1.getName());                // text.txt
        System.out.println("path:"  + file1.getAbsolutePath());        // C:\Use...xt.txt
        System.out.println("dir?:"  + file1.isDirectory());            // false
        System.out.println("file?"  + file1.isFile());                 // true
        System.out.println("len:"   + file1.length());                 // 0
        System.out.println("time:"  + file1.lastModified());           // 1575574334389
        System.out.println("ren:"   + file1.renameTo(file2));          // true
        System.out.println("del:"   + file2.delete());                 // true

        File dir1  = new File("C:\\Users\\Танюшка\\Desktop\\Sample\\dir");
        File dir2  = new File("C:\\Users\\Танюшка\\Desktop\\Sample\\dirs\\dirs");
        File dir3  = new File("C:\\Users\\Танюшка");
        File dir4  = new File("C:\\");
        File dir5  = new File("C:\\Users\\Танюшка\\Desktop\\Sample");

        System.out.println("dir:"       + dir1.mkdir());               // true
        System.out.println("dirs/dirs:" + dir2.mkdirs());              // true
        System.out.println("par:"       + dir3.getParent());           // C:\Users
        System.out.println("par C:"     + dir4.getParent());           // null
        for (File name : dir5.listFiles()) System.out.println(name);
        // C:\Users\Танюшка\Desktop\Java\JavaRush\Проекты\Sample\dir
        // C:\Users\Танюшка\Desktop\Java\JavaRush\Проекты\Sample\dirs
        // C:\Users\Танюшка\Desktop\Java\JavaRush\Проекты\Sample\file1.txt
        // C:\Users\Танюшка\Desktop\Java\JavaRush\Проекты\Sample\file2.txt
        // C:\Users\Танюшка\Desktop\Java\JavaRush\Проекты\Sample\file3.txt
        // C:\Users\Танюшка\Desktop\Java\JavaRush\Проекты\Sample\text.txt
    }}
