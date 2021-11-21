package OCP.Chapter7;
import java.util.concurrent.*;
public class FutureMethods implements Runnable{
    @ Override public void run() {System.out.println("Future");}

    public static void main(String[] args) throws Exception{
        ExecutorService servise = null;

        try{
            servise = Executors.newSingleThreadExecutor();
            Future <?> name1 = servise.submit( () -> "Future" );
            Thread.sleep(1000);

            System.out.println(name1.isDone());                 // true

            System.out.println(name1.isCancelled());            // false

            System.out.println(name1.get());                    // Future

            System.out.println(name1.get(1,TimeUnit.SECONDS));  // Future
        }
        finally {if (servise!=null) servise.shutdown();}
    }}
