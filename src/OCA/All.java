package OCA;

public class All {

    static int XXXXXX = 5;

    static int YYYYYY (int p){
        p = p +5;
        return p;
    }

    public static void varags (String [] x, int ... y){}



    public static void main(String[] args) {

        String [] xxx = new String[5];
        int[] yt = new int [5];
        varags(xxx,yt);

        final int qqq = 5;
        int www = 7;

        var var = new var();

        var.xxx(qqq);
        System.out.println(qqq);

        var.xxx(www);
        System.out.println(www);

        final StringBuilder stringBuilder = new StringBuilder("vas");

        var.str(stringBuilder);
        System.out.println(stringBuilder);

        System.out.println(YYYYYY(XXXXXX));
        System.out.println(XXXXXX);


        Integer wqw = new Integer("5");

        System.out.println(wqw.compareTo(4));
        System.out.println(wqw.compareTo(5));
        System.out.println(wqw.compareTo(6));

        int a = 10;
        int b = 20;
        int c = (a * (b+2)) - 10 - 4 * ((2*2) - 6);
        System.out.println(c);



    }
}

    class var {

        int xxx(int x) {
            x = x + 2;
            return x;
        }

        void str(StringBuilder x) {
            x.append("qqq");
        }
    }
