package OCA;

public class SwitchClass {
        static void print (){System.out.println("switch accepted");}
        public static void main(String[] args) {
        int num = 10;
        switch (num){
            case 0:  print();
            case 10: print();
            default: print();
            case 20: print(); break;
        }}}
