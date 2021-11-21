package OCP.Chapter7;
import java.util.concurrent.Callable;

// 1. Creating by implements Runnable
// @FunctionalInterface public interface Runnable { void run(); }
public class CreatingThread implements Runnable{
    @Override public void run() { System.out.println("Runnable");}

    public static void main(String[] args) {
        (new Thread(new CreatingThread())).start();
    }}

// 2. Creating by extends Thread
// public class Thread extends Object implements Runnable
class CreatingThread2 extends Thread{
    @Override public void run() { System.out.println("Thread");}

    public static void main(String[] args) {
        new CreatingThread2().start();
    }}

// 3. Creating by implements Callable - old version Runnable in Java 5
// @FunctionalInterface public interface Callable <V> { V call() throws Exception; }
class CreatingThread3 implements Callable {
    @Override public Object call() throws Exception { return null; }

    public static void main(String[] args) throws Exception {
        // Creating by ExecutorService
    }}
