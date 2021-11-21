package OCA;

public class StringBuilderMethod {
        static class Person               {
            String name;
            Person(String str){name = str;}   }

        static StringBuilder renew (StringBuilder x) //0123456
        {        return x.delete(0,x.length()).append("ABC_ABC");    }

        static void print (StringBuilder x) {System.out.println(x);}
        static void print (int x)           {System.out.println(x);}
        static void print (char x)          {System.out.println(x);}
        static void print (CharSequence x)  {System.out.println(x);}

        public static void main(String[] args) {
        StringBuilder sb  = new StringBuilder("S");
        StringBuilder sb1 = new StringBuilder(sb);          // accept StringBuilder obj
        StringBuilder sb2 = new StringBuilder(20);  // accept int capacity
        char[] x = {'a','s','d'}; String stringnull = null;

        print(sb.append(1).append(sb).append('C').append(1.01F)
        .append(true).append(1.00d).append("AB").append(111L).append(x)
        .append(x,0,1).append(new Person("Vlad")));
        // print: S1S1C1.01true1.0AB111asdaStringBuilderMethod$Person@1b6d3586 (change)

        print(sb.delete(5,sb.length()));                      // print: S1S1C (change)

        print(renew(sb).insert(2,'_'));             // print: AB_C_ABC (change)
        print(renew(sb).insert(1,x,1,2));   // print: AsdBC_ABC (change)
        // insert can work with the same objects like append

        print(renew(sb).deleteCharAt(3));                     // print: ABCABC (change)

        print(renew(sb).reverse());                           // print: CBA_CBA (change)

        print(renew(sb).replace(1,5,"123"));   // print: A123BC (change)
        // print(renew(sb).replace('A','a'));                 don't work
        // print(renew(sb).replace("BC","12"));               don't work

        print(renew(sb).subSequence(1,3));                    // print: BC (NO change, CharSequence)

        print(sb.charAt(3));                                  // print: _ (NO change, char)

        print(sb.indexOf("BC"));                              // print: 1 (NO change,int)
        print(sb.indexOf("B",2));               // print: 5 (NO change,int)
        print(sb.indexOf("Q"));                               // print: -1 (NO change,int)
        // print(sb.indexOf('A'));                            don't work
        // print(sb.indexOf('A',3));                          don't work

        print(sb.substring(4));                         // print: ABC (NO change, String)
        print(sb.substring(1,3));                             // print: BC (NO change, String)

        print(sb.length());                                   // print: 7 (NO change, int)

        // print(sb.startsWith());                            don't work

        // print(name.endsWith());                            don't work

        // print(sb.trim());                                  don't work

        // print(sb.concat("_ABC"));                          don't work

        // System.out.println(sb + sb);                       don't work
        // System.out.println(sb += sb);                      don't work

        print(stringnull + sb);                               // print: nullABC_ABC
        print(renew(sb) + stringnull);                        // print: ABC_ABCnull
        print(stringnull += sb);                              // print: nullABC_ABC
        print(stringnull + stringnull);                       // print: nullABC_ABCnullABC_ABC
        }}
