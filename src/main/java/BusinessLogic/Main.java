package BusinessLogic;

import DataModels.Monom;
import DataModels.Polynomial;

public class Main {
    public static void main(String[] args) {
        Polynomial A = new Polynomial();
        Polynomial B = new Polynomial();
        Polynomial C = new Polynomial();
        Polynomial D = new Polynomial();
        Operatii operatii = new Operatii();

        Monom m1 = new Monom(2, 2);
        Monom m2 = new Monom(2, 0);
        Monom m3 = new Monom(1, 1);
        Monom m4 = new Monom(1, 0);
        Monom m5 = new Monom(3, 2);
        Monom m6 = new Monom(4, 2);
        Monom m7 = new Monom(2, 0);


        System.out.println("Monom1= " + m1.toString());
        System.out.println("Monom2= " + m2.toString());
        System.out.println("Monom3= " + m3.toString());
        System.out.println("Monom4= " + m4.toString());
        System.out.println("Monom5= " + m5.toString());
        System.out.println("Monom6= " + m6.toString());

        A.getPolinom().put(1,m1);
        A.getPolinom().put(2,m2);
        //A.getPolinom().put(3,m5);
        System.out.println("A= " + A.toString());
        B.getPolinom().put(4,m1);
        B.getPolinom().put(5,m2);
        D.getPolinom().put(6,m7);
        System.out.println("B= " + B.toString());
        System.out.println("D= " + D.toString());
        C = operatii.scadere(A,B);
        System.out.println("C= " + C.toString());


    }
}