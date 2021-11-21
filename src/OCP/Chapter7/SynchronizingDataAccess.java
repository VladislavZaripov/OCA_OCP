package OCP.Chapter7;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public class SynchronizingDataAccess {}

class WithoutAll {
    private int count = 0;
    private void incrementAndReport () { System.out.print((++count) + " ");}

    public static void main(String[] args) {
        ExecutorService service = null;
        try {service = Executors.newFixedThreadPool(20);
            WithoutAll withoutAll = new WithoutAll();
        for (int i = 0; i<10; i++) service.submit(() -> withoutAll.incrementAndReport());
        }
        finally {if (service!=null) service.shutdown();}
    }}          // can print:  1 2 2 3 4 4 6 5 8 7  -   not ordered, can access in same time

class WithAtomic {
    private AtomicInteger count = new AtomicInteger();
    private void incrementAndReport () { System.out.print((count.incrementAndGet()) + " ");}

    public static void main(String[] args) {
        ExecutorService service = null;
        try {service = Executors.newFixedThreadPool(20);
            WithAtomic withAtomic = new WithAtomic();
            for (int i = 0; i<10; i++) service.submit(() -> withAtomic.incrementAndReport());
        }
        finally {if (service!=null) service.shutdown();}
    }}          // can print:  2 3 1 4 5 6 7 8 9 10   -  not ordered

class WithSynchronizedBlocksAndMethods {
    private int count = 0;
    private void incrementAndReport () {  // or private synchronized void incrementAndReport
    synchronized (this) {System.out.print((++count) + " ");}} // or without synchronized (this)

    public static void main(String[] args) {
        ExecutorService service = null;
        try {service = Executors.newFixedThreadPool(20);
            WithSynchronizedBlocksAndMethods Synch = new WithSynchronizedBlocksAndMethods();
            for (int i = 0; i<10; i++) service.submit(() -> Synch.incrementAndReport());
        }
        finally {if (service!=null) service.shutdown();}
    }}          // can print:  1 2 3 4 5 6 7 8 9 10   -   perfect!
