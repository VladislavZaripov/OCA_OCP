package OCP.Chapter7;
import java.util.concurrent.*;
public class ExecutorsMethods {
    public static void main(String[] args) {
        ExecutorService service1 = Executors.newSingleThreadExecutor();

        ScheduledExecutorService service2 = Executors.newSingleThreadScheduledExecutor();

        ExecutorService service3 = Executors.newCachedThreadPool();

        ExecutorService service4 = Executors.newFixedThreadPool(3);

        ScheduledExecutorService service5 = Executors.newScheduledThreadPool(3);
    }}
