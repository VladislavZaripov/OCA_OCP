package OCP.Chapter6;
class Cage implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Close gate");}
}
public class Exception_AutoCloseable {
    public static void main(String[] args) throws Exception{
        try (Cage cage = new Cage())
        //  <- at this point resource are closed
        {}
}}
// Interface AutoCloseable implements method
// public void close () throws Exception
// Java doesn't recommend to use Exception.
// It is better use subclass, for example IllegalStateException or nothing.
