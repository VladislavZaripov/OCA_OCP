package OCP.Chapter6;
class TestException extends Exception{
    public TestException ()             {super ()  ;}
    public TestException (Exception e)  {super (e) ;}
    public TestException (String e)     {super (e) ;}
}
public class Exception_outputs {
    public static void main(String[] args) throws TestException{
    //  throw new TestException();
        //  Exception in thread "main" OCP.Chapter6.TestException
        //  at OCP.Chapter6.Exception_outputs.main(Exception_outputs.java:7)

    //  throw new TestException(new RuntimeException());
        //  Exception in thread "main" OCP.Chapter6.TestException: java.lang.RuntimeException
        //  at OCP.Chapter6.Exception_outputs.main(Exception_outputs.java:16)
        //  Caused by: java.lang.RuntimeException
	    //  ... 1 more

    //  throw new TestException("some TEXT");
        //  Exception in thread "main" OCP.Chapter6.TestException: some TEXT
        //  at OCP.Chapter6.Exception_outputs.main(Exception_outputs.java:22)

    try                 {throw new TestException();}
    catch (Exception e) {e.printStackTrace();}
    // OCP.Chapter6.TestException
    //	   at OCP.Chapter6.Exception_outputs.main(Exception_outputs.java:25)
}}
