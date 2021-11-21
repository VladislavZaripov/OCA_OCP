package OCP.Chapter7;
public class PollingWithSleep implements Runnable{
    @Override public void run()
    { for (int i=1; i<=2; i++)
        System.out.println("new Thread count " + i + " and don't wait"); }

    public static void main(String[] args) throws InterruptedException{
        (new Thread(new PollingWithSleep())).start();
        Thread.sleep(1000);
        System.out.println("Main Thread waited 1 second");
}}
        // new Thread count 1 and don't wait
        // new Thread count 2 and don't wait
        // Main Thread waited 1 second

 class PollingWithSleep1 implements Runnable{
    @Override public void run()
    { for (int i=1; i<=2; i++) try {Thread.sleep(1000);
        System.out.println("new Thread wait 1 second and count" + i);
    } catch (InterruptedException e){}}

    public static void main(String[] args){
        (new Thread(new PollingWithSleep1())).start();
        System.out.println("Main Thread don't wait");
    }}
        // Main Thread don't wait
        // new Thread wait 1 second and count1
        // new Thread wait 1 second and count2
