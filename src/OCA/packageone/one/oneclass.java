package OCA.packageone.one;
import OCA.packagetwo.two.*;
import static OCA.packagethree.three.staticthreeclass.threestatic;
import static OCA.packagethree.three.staticthreeclass.threestaticmethod;
import static OCA.packagethree.three.staticthreeclass.*;

public class oneclass extends OCA.packagethree.three.threeclass implements oneinterface,twointerface, OCA.packagethree.three.threeinterface{
    public static void main(String[] args) {

        System.out.println("sfg" +
                "sdfg" +
                "g");

        twoclass two = new twoclass();
        two.printtwo();

        OCA.packagethree.three.threeclass three = new OCA.packagethree.three.threeclass();
        three.printthree();

        String xxx = "main two";
        main(xxx);

        System.out.println(threestatic);
        System.out.println(threestatic2);
        threestaticmethod();



    }

    String getname (){return name;}

    public static void main (String args){
        System.out.println(args);
    }


}


