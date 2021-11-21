package OCA.inheritance;

public class Class3 {
    public static void main(String[] args) {
        Class1 class1 = new Class1();
        Class1 class12 = new Class2();
        Class2 class2 = new Class2();

        /* Access to static and instance fields and static methods depends on the class
         of reference variable and not the actual object to which the variable points to. */
        System.out.println(class1.class1int);               // 1
        System.out.println(class12.class1int);              // 1
        System.out.println(class2.class1int);               // 2
        System.out.println(class1.class1statint);           // 1
        System.out.println(class12.class1statint);          // 1
        System.out.println(class2.class1statint);           // 2
        class1.printstat();                                 // class1
        class12.printstat();                                // class1
        class2.printstat();                                 // class2

        System.out.println(new Class1().class1int);         // 1
        System.out.println(new Class2().class1int);         // 2
        System.out.println(new Class1().class1statint);     // 1
        System.out.println(new Class2().class1statint);     // 2

        /* Access to instance methods depends on object to which the variable points to. */
        class1.print();                                     // class1
        class12.print();                                    // class2
        class2.print();                                     // class2



    }
}
