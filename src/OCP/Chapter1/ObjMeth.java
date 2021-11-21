package OCP.Chapter1;
public class ObjMeth {
    String name; int age;
    public ObjMeth(String name, int age) {
        this.name = name;
        this.age = age;                        }

    @Override public String toString()
    {return "Name: " + name +", Age: " + age;}

    @Override public boolean equals (Object o){
        if (!(o instanceof ObjMeth)) return false;
        ObjMeth objMeth = (ObjMeth) o;
        return name.equals(objMeth.name) && age == objMeth.age; }

    @Override public int hashCode() {
        return name.hashCode()*age;  } // primitives don't have methods

    public static void main(String[] args) {
        ObjMeth objMeth1 = new ObjMeth("Vlad",34);
        ObjMeth objMeth2 = new ObjMeth("Vlad",34);
        ObjMeth objMeth3 = null;
        ObjMeth objMeth4;

        System.out.println(objMeth1);                                   // Name: Vlad, Age: 34
        System.out.println(objMeth1.equals(objMeth2));                  // true
        System.out.println(objMeth1.equals(objMeth3));                  // false
    //  System.out.println(objMeth1.equals(objMeth4));                  // not compile
        System.out.println(objMeth1.hashCode()==objMeth2.hashCode());   // true
    //  System.out.println(objMeth1.hashCode()==objMeth3.hashCode());   // NullPointerException
    //  System.out.println(objMeth1.hashCode()==objMeth4.hashCode());   // not compile
    }}
/*    The equals() method implements an equivalence relation on non‐null object references:
■■ It is reflexive: For any non‐null reference value x, x.equals(x) should return true.
■■ It is symmetric: For any non‐null reference values x and y, x.equals(y) should return
true if and only if y.equals(x) returns true.
■■ It is transitive: For any non‐null reference values x, y, and z, if x.equals(y) returns
true and y.equals(z) returns true, then x.equals(z) should return true.
■■ It is consistent: For any non‐null reference values x and y, multiple invocations of
x.equals(y) consistently return true or consistently return false, provided no
information used in equals comparisons on the objects is modified.
■■ For any non‐null reference value x, x.equals(null) should return false.               */
