package OCP.Chapter3;
// Common letters for generics
// E for an element
// K for a map key
// V for a map value
// N for a number
// T for a generic data type
// S, U, V, and so forth for multiple generic types

/* Generic Class */

class Human1{}

public class Generic <E,N>{
    private E somebody;
    private N num;
    public Generic(E somebody, N num) {this.somebody = somebody;this.num = num;}
    public E getSomebody() {return somebody;}
    public N getNum()      {return num;}

    public static void main(String[] args) {
    Human1 human1 = new Human1();
    Integer age = 35;
    Generic <Human1,Integer> human1IntegerGeneric = new Generic<>(human1,age);
    Human1 clone = human1IntegerGeneric.getSomebody();
    Integer ageclone = human1IntegerGeneric.getNum();
    }}

/* Generic Interfaces */

class Class1{}
class Class2{}
interface GenericInterface <T> {void interfacemethod (T t);}

class Mainclass1 implements GenericInterface<Class1>{
    public void interfacemethod (Class1 t) {}      }
class Mainclass2 implements GenericInterface<Class2>{
    public void interfacemethod (Class2 t) {}      }

/* Generic Methods */

class Thing <T> {}
class GenericMethod{
    public static <T> Thing <T> method1 (T t){return new Thing<>();}
    public static <T> T         method2 (T t){return t;}
    public static <T> void      method3 (T t){return;}
//  public static     Thing <T> method1 (T t){return new Thing<>();}  // don't compile
}
