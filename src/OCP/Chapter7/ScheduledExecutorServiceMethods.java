package OCP.Chapter7;
import java.util.concurrent.*;
public class ScheduledExecutorServiceMethods {
    public static void main(String[] args) {
        ScheduledExecutorService service = null;
        try{
service = Executors.newSingleThreadScheduledExecutor();

Future <String> name = service.schedule( () -> "Callable",1,TimeUnit.SECONDS);

service.schedule(() -> System.out.println("Runnable"),1,TimeUnit.SECONDS);

service.scheduleAtFixedRate( () -> System.out.println("Runnable"),1,1,TimeUnit.SECONDS);

service.scheduleWithFixedDelay( () -> System.out.println("Runnable"),1,1,TimeUnit.SECONDS);
        }
        finally { if (service!=null) service.shutdown(); }
    }}
