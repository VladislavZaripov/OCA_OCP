package OCP.Chapter7;
import java.util.concurrent.*;
public class Liveness {}

/* Deadlock */
    class Food {}
    class Water {}
    class Fox {
        public void eatAndDrink(Food food, Water water) {
            synchronized(food) {System.out.println("Got Food!");
                move();
                synchronized(water) {System.out.println("Got Water!"); }}
        }
        public void drinkAndEat(Food food, Water water) {
            synchronized(water) {System.out.println("Got Water!");
                move();
                synchronized(food) {System.out.println("Got Food!"); }}
        }
        public void move() {
            try {Thread.sleep(100);} catch (InterruptedException e) {}
        }
        public static void main(String[] args) {
            Fox foxy = new Fox();
            Fox tails = new Fox();
            Food food = new Food();
            Water water = new Water();

            ExecutorService service = null;
            try {
                service = Executors.newScheduledThreadPool(10);
                service.submit(() -> foxy.eatAndDrink(food,water));
                service.submit(() -> tails.drinkAndEat(food,water));
            }
            finally {if(service != null) service.shutdown();}
    } } // print: Got Food! and Got Water!, then hangs indefinitely

/* Starvation */
// For example, a lot of Fox try to use one Food.
// One Fox can never get it and became starving.

/* Livelock */
// For example, Fox and Tail stay in Deadlock. After that we upgrade
// the program and tell to animal find another recourse if one is blocked.
// But actually Fox and Tail just will change recourse and never get the end.
// Livelock is often a result of two threads trying to resolve a deadlock.
