package OCP.Chapter6;
public class Suppressed_Exseptions{}
class CaseOne implements AutoCloseable{
    @Override public void close() throws IllegalStateException  {
        throw new IllegalStateException("Suppressed Exception");}

    public static void main(String[] args) {
        try (CaseOne caseOne = new CaseOne())
            {throw new IllegalStateException(" First Exception");}
        catch (IllegalStateException e){
            System.out.println("Caught" + e.getMessage());
            for (Throwable t : e.getSuppressed()) System.out.println(t.getMessage());}
                        /* Print */
                // Caught First Exception
                // Suppressed Exception
}}

class CaseTwo implements AutoCloseable{
    @Override public void close() throws IllegalStateException  {
        throw new IllegalStateException(" Exception");}

    public static void main(String[] args) {        // Close in reverse order
        try (CaseTwo caseTwo1 = new CaseTwo();      // <- Close second
             CaseTwo caseTwo2 = new CaseTwo())      // <- Close first
            {}
        catch (IllegalStateException e){
            System.out.println("Caught" + e.getMessage());
            for (Throwable t : e.getSuppressed()) System.out.println(t.getMessage());}
                        /* Print */
                // Caught Exception  <- from caseTwo2
                // Exception         <- from caseTwo1
    }}

class CaseThree implements AutoCloseable{
    @Override public void close() throws IllegalStateException  {
        throw new IllegalStateException(" Exception is lost");}

    public static void main(String[] args) {
        try (CaseThree caseThree = new CaseThree())
            {throw new IllegalStateException("Exception is lost");}
        finally {throw new RuntimeException("Only this Exception");}
                        /* Print */
        // Exception in thread "main" java.lang.RuntimeException: Only this Exception
        //	at OCP.Chapter6.CaseThree.main(Suppressed_Exseptions.java:46)
    }}
