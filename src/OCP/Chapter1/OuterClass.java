package OCP.Chapter1;
public class OuterClass {
    private interface privateinterface{ void print(); }
    static int staticout = 1;
    private int privateout = 2;

/*  Member inner class  */
    class Memberinner implements privateinterface{
        public void print()                                                 // must be public
        {System.out.println(staticout + privateout);}  }

/*  Local inner class  */
    void methodforlocal(int var){
        int var1 = 1;                                                       // effectively final
        int var2 = var;                                                     // effectively final
        int var3 = 3; var3++;                                               // is NOT effectively final
        int var4; if (var>4) var4 = 4; else var4 = 4;                       // effectively final
        int var5 = 5;                                                       // is NOT effectively final
        class Localinner implements privateinterface{
        public void print(){System.out.println(staticout + privateout + var + var1 + var2 + var4);}}
        var5 = 5;                                                           // is NOT effectively final
        int var6 = 6;                                                       // is NOT effectively final
        Localinner localinner = new Localinner();
        localinner.print(); }

/*  Anonymous inner class  */
    abstract class Anonymousinner{abstract void print();}                   // can use class or interface
    void methodforAnonymous(){
        Anonymousinner anonymousinner = new Anonymousinner() {              // can use like argument in method
            @Override void print(){System.out.println("Anonymousinner");}}; // need semicolon
        anonymousinner.print();    }

/*  Static inner class  */
    static class Staticinner {private static int staticinner = 7;}

/*  Main method  */
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        Memberinner memberinner1 = outerClass.new Memberinner();
        OuterClass.Memberinner memberinner2 = new OuterClass().new Memberinner();

        memberinner1.print();                                               // 3
        outerClass.methodforlocal(0);                                       // 8
        outerClass.methodforAnonymous();                                    // Anonymousinner

        Staticinner staticinner1 = new Staticinner();
    //  Staticinner staticinner2 = outerClass1.new Staticinner();           // not compile
        System.out.println(staticinner1.staticinner);                       // 7
        System.out.println(staticinner1);      // OCP.Chapter1.OuterClass$Staticinner@1b6d3586
    }}
