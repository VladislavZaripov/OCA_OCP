package OCA;


public class nopackage {


    public static void main(String[] args) {
        nopackage2 nopackage2 = new nopackage2();
        Lambda lambda = new Lambda();
        double d1 = 12;
        double d2 = 12.00;
        // Double d3 = 12; wil not compile
        Double d4 = 12.00;

        System.out.println(true);
        System.out.println(false);
        // System.out.println(null); wil not compile
        // System.out.println(true + null); wil not compile
        // System.out.println(null + true); wil not compile
        System.out.println(nopackage2);
        System.out.println('c' + "sdfg" + null + true);
        System.out.println(12.0000f); // print 12.0
        System.out.println(12.00000); // print 12.0

    }

}
