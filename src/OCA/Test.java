package OCA;

class Base{
    String varA = "base - varA";
    String varB = "base - varB";
    static String staticvarA = "base - staticvarA";
    static String staticvarB = "base - staticvarB";
    static void printA (){System.out.println("base - printA");}
    static void printB (){System.out.println("base - printB");}
    void methodA(){System.out.println("base - MethodA");}
    void methodB(){System.out.println("base - MethodB");}}
class Sub extends Base{
    String varA = "sub - varA";
    String varC = "sub - varC";
    static String staticvarA = "sub - staticvarB";
    static String staticvarC = "sub - staticvarC";
    static void printA (){System.out.println("sub - printA");}
    static void printC (){System.out.println("sub - printC");}
    public void methodA(){System.out.println("sub - MethodA");}
    public void methodC(){System.out.println("sub - MethodC");}

    public static void main(String args[]){
        Base run = new Sub();System.out.println("OCA.Base run = new OCA.Sub()");
        run.methodA();                         // print: sub - MethodA
        run.methodB();                         // print: base - MethodB
        // run.methodC();                      will not compile
        System.out.println(run.varA);          // print: base - varA
        System.out.println(run.varB);          // print: base - varB
        // System.out.println(run.varC);       will not compile
        System.out.println(run.staticvarA);    // print: base - staticvarA
        System.out.println(run.staticvarB);    // print: base - staticvarB
        // System.out.println(run.staticvarC); will not compile
        run.printA();                          // print: base - printA
        run.printB();                          // print: base - printB
        // run.printC();                       will not compile

        Sub run1 = new Sub();System.out.println("OCA.Sub run = new OCA.Sub()");
        run1.methodA();                         // print: sub - MethodA
        run1.methodB();                         // print: base - MethodB
        run1.methodC();                         // print: sub - MethodC
        System.out.println(run1.varA);          // print: sub - varA
        System.out.println(run1.varB);          // print: base - varB
        System.out.println(run1.varC);          // print: sub - varC
        System.out.println(run1.staticvarA);    // print: sub - staticvarB
        System.out.println(run1.staticvarB);    // print: base - staticvarB
        System.out.println(run1.staticvarC);    // print: sub - staticvarC
        run1.printA();                          // print: sub - printA
        run1.printB();                          // print: base - printB
        run1.printC();                          // print: sub - printC
    }}

