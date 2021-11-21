package OCP.Chapter7;
import java.util.*;
import java.util.concurrent.*;
public class ManagingConcurrentProcesses {}

/* CyclicBarrier */
class CreatingCyclicBarrier {
    public void thread (CyclicBarrier c1, CyclicBarrier c2){
        try {
            System.out.print("ready ");
            c1.await();                     // wait 3 thread
            System.out.print("run ");
            c2.await();                     // wait 3 thread and print
            System.out.print("go home! ");
        }
        catch (InterruptedException | BrokenBarrierException e) {}
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(3);
            CyclicBarrier c1 = new CyclicBarrier(3);
            CyclicBarrier c2 = new CyclicBarrier(3,() -> System.out.print("ALL GET FINISH "));
            CreatingCyclicBarrier MCP = new CreatingCyclicBarrier();
            for (int i=0; i<3; i++)
            service.submit( () -> MCP.thread (c1,c2) );
        }
        finally {if (service!=null) service.shutdown();}
    }}    // print: ready ready ready run run run ALL GET FINISH go home! go home! go home!

/* public abstract class RecursiveAction extends ForkJoinTask<Void> */
/*                 protected abstract void compute()                */
class Action extends RecursiveAction {
    private Double [] weights; private int start; private int end;
    Action (Double[] weights, int start, int end){
        this.weights = weights; this.start = start; this.end = end;
    }
    @Override protected void compute() {
        if(end-start<=3)
            for (int i =start; i <end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i); }
        else {
            int middle = start + ((end - start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            invokeAll(new Action(weights,start,middle), new Action(weights,middle,end));
        }}
    public static void main(String[] args) {
        Double[] weights = new Double[10];
        ForkJoinTask <?> task = new Action (weights,0,weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        Arrays.asList(weights).stream().forEach(q-> System.out.print(q.intValue() + " "));
    }}
                // [start=0,middle=5,end=10]
                // [start=0,middle=2,end=5]
                // Animal Weighed: 0
                // Animal Weighed: 1
                // Animal Weighed: 2
                // Animal Weighed: 3
                // Animal Weighed: 4
                // [start=5,middle=7,end=10]
                // Animal Weighed: 5
                // Animal Weighed: 6
                // Animal Weighed: 7
                // Animal Weighed: 8
                // Animal Weighed: 9
                // 51 1 45 76 35 80 84 55 22 72

/* public abstract class RecursiveTask<V> extends ForkJoinTask<V> */
/*                 protected abstract V compute()                 */
class Task extends RecursiveTask <Double> {
    private Double [] weights; private int start; private int end;
    Task (Double[] weights, int start, int end){
        this.weights = weights; this.start = start; this.end = end;
    }
    @Override protected Double compute() {
        if(end-start<=3) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                weights[i] = (double) new Random().nextInt(100);
                System.out.println("Animal Weighed: " + i);
                sum += weights[i];            }
            return sum;  }
        else {
            int middle = start + ((end - start)/2);
            System.out.println("[start="+start+",middle="+middle+",end="+end+"]");
            RecursiveTask <Double> otherTask = new Task(weights,start,middle);
            otherTask.fork();
            return new Task(weights,middle,end).compute() + otherTask.join();
        }}
    public static void main(String[] args) {
        Double[] weights = new Double[10];
        ForkJoinTask <Double> task = new Task(weights,0,weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        Double sum = pool.invoke(task);
        System.out.println(sum);
    }}
                // [start=0,middle=5,end=10]
                // [start=5,middle=7,end=10]
                // Animal Weighed: 7
                // Animal Weighed: 8
                // Animal Weighed: 9
                // Animal Weighed: 5
                // Animal Weighed: 6
                // [start=0,middle=2,end=5]
                // Animal Weighed: 2
                // Animal Weighed: 3
                // Animal Weighed: 4
                // Animal Weighed: 0
                // Animal Weighed: 1
                // 615.0


