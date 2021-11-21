package OCA;

public class StringMethod {
        public static void main(String[] args) {
        String name = "ABC_ABC";             // String immutable sequence of characters
        //             0123456
        System.out.println(name.charAt(2));                             // print: C

        System.out.println(name.indexOf('A'));                          // print: 0
        System.out.println(name.indexOf('A',3));          // print: 4
        System.out.println(name.indexOf("BC"));                         // print: 1
        System.out.println(name.indexOf("BC",4));         // print: 5
        System.out.println(name.indexOf('Q'));                          // print: -1

        System.out.println(name.substring(4));                          // print: ABC
        System.out.println(name.substring(2,6));                        // print: C_AB

        System.out.println("   1  23   ".trim());                       // print: 1  23

        System.out.println(name.replace('A','a'));     // print: aBC_aBC
        System.out.println(name.replace("BC","12"));  // print: A12_A12
        // System.out.println(name.replace("BC",'2'));                  won't compile
        // System.out.println(name.replace('A',"12"));                  won't compile

        System.out.println(name.length());                              // print: 7

        System.out.println(name.startsWith("A"));                       // print: true
        System.out.println(name.startsWith("BC"));                      // print: false
        System.out.println(name.startsWith("ABC",4));     // print: true

        System.out.println(name.endsWith("ABC"));                       // print: true
        System.out.println(name.endsWith("B"));                         // print: false

        System.out.println(name.concat("_ABC"));                        // print: ABC_ABC_ABC

        System.out.println(name+name);                                  // print: ABC_ABCABC_ABC
        System.out.println(name+=name);                                 // print: ABC_ABCABC_ABC
        // += - change value of String
        String Null = null; System.out.println(Null += name);           // print: nullABC_ABCABC_ABC
        }}
