package OCP.Chapter7;
import java.util.concurrent.*;
public class ExecutorServiceFactory {
    public static void main(String[] args) throws Exception{
        ExecutorService service = null;
        try{
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(()-> System.out.println("go"));
            service.execute(()-> {for(int i=0; i<=3; i++) System.out.println(i);});
            service.execute(()-> System.out.println("stop"));
            System.out.println("end");
        }
        finally {
            if (service!=null) service.shutdown();
        }
            if (service!=null) { service.awaitTermination(1,TimeUnit.SECONDS);
            if (service.isTerminated()) System.out.println("Task finished");
                else System.out.println("Task did not finish");}
}}
        // begin     -   main thread, print in order main
        // end       -   main thread, print in order main
        // go        -   main thread, print in order main
        // 0         -   service single thread, print in order service.execute
        // 1         -   service single thread, print in order service.execute
        // 2         -   service single thread, print in order service.execute
        // 3         -   service single thread, print in order service.execute
        // stop      -   service single thread, print in order service.execute
        // Task finished

