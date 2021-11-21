package OCP.Chapter7;
import java.util.concurrent.*;
public class ExecutorServiceMethods {
    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();

            service.execute(()-> System.out.println("execute"));

            Future<String> name1 = service.submit(()-> "submit");
            System.out.println(name1);      // java.util.concurrent.FutureTask@7cca494b
        }
        finally { if (service!=null) service.shutdown(); }
    }}
