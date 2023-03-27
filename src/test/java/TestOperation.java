import BusinessLogic.Operatii;
import DataModels.Monom;
import DataModels.Polynomial;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestOperation {
    @Test
    public void testAdunare(){
        Operatii op = new Operatii();
        Polynomial A = new Polynomial();
        Polynomial B = new Polynomial();
        Polynomial D = new Polynomial();
        Polynomial reuslt;

        Monom m1 = new Monom(2, 1);
        Monom m2 = new Monom(3, 2);
        Monom m3 = new Monom(2, 2);
        Monom m4 = new Monom(0, 0);

        A.getPolinom().put(1,m1);
        A.getPolinom().put(2,m2);
        B.getPolinom().put(1,m3);

        reuslt = op.adunare(A, B);
        assertEquals(reuslt.toString(), "+2.0*x^1+5.0*x^2");

        m1 = new Monom(3.2, 1);
        m2 = new Monom(7,2);
        m3 = new Monom(2,3);
        m4= new Monom(-2.3,1);

        A.getPolinom().put(1,m1);
        A.getPolinom().put(2,m2);
        B.getPolinom().put(1,m3);
        B.getPolinom().put(2,m4);
        reuslt = op.adunare(A, B);
        assertEquals(reuslt.toString(), "+0.9000000000000004*x^1+7.0*x^2+2.0*x^3");

        Monom m5 = new Monom(0,0);
        D.getPolinom().put(1,m5);
        reuslt=op.adunare(D,A);
        assertNotEquals(reuslt.toString(), "-3.2*x^1-7.0*x^2");
        assertEquals(reuslt.toString(),"+3.2*x^1+7.0*x^2");

    }
    @Test
    public  void testScadere(){
        Operatii op = new Operatii();
        Polynomial A = new Polynomial();
        Polynomial B = new Polynomial();
        Polynomial D = new Polynomial();
        Polynomial reuslt;

        Monom m1 = new Monom(2, 1);
        Monom m2 = new Monom(3, 2);
        Monom m3 = new Monom(2, 2);
        Monom m4 = new Monom(0, 0);

        A.getPolinom().put(1,m1);
        A.getPolinom().put(2,m2);
        B.getPolinom().put(1,m3);

        reuslt = op.scadere(A, B);
        assertEquals(reuslt.toString(), "+2.0*x^1+x^2");

        m1 = new Monom(3.2, 1);
        m2 = new Monom(7,2);
        m3 = new Monom(2,3);
        m4= new Monom(-2.3,1);

        A.getPolinom().put(1,m1);
        A.getPolinom().put(2,m2);
        B.getPolinom().put(1,m3);
        B.getPolinom().put(2,m4);
        reuslt = op.scadere(A, B);
        assertEquals(reuslt.toString(), "+5.5*x^1+7.0*x^2-2.0*x^3");

        Monom m5 = new Monom(0,0);
        D.getPolinom().put(1,m5);
        reuslt=op.scadere(D,A);
        assertEquals(reuslt.toString(), "-3.2*x^1-7.0*x^2");
        assertNotEquals(reuslt.toString(),"+3.2*x^1+7.0*x^2");



    }

    @Test
    public  void testInmultire(){
        Operatii op = new Operatii();
        Polynomial A = new Polynomial();
        Polynomial B = new Polynomial();
        Polynomial reuslt = new Polynomial();

        Monom m1 = new Monom(2, 1);
        Monom m2 = new Monom(3, 2);
        Monom m3 = new Monom(2, 0);
        Monom m4 = new Monom(0, 0);

        A.getPolinom().put(1,m1);
        A.getPolinom().put(2,m2);

        B.getPolinom().put(3,m3);
        B.getPolinom().put(4,m4);
        reuslt = op.inmultire(A, B);
        assertEquals(reuslt.toString(), "+4.0*x^1+6.0*x^2");

        B.getPolinom().remove(3,m3);
        B.getPolinom().put(3,m4);

        reuslt = op.inmultire(A, B);

        assertEquals(reuslt.toString(),"0");
        assertNotEquals(reuslt.toString(),"+2.0*x^1+3.0*x^2");

    }
    @Test
    public  void testDerivare(){
        Operatii op = new Operatii();
        Polynomial A = new Polynomial();
        Polynomial B = new Polynomial();
        Polynomial C = new Polynomial();

        Monom m1 = new Monom(2, 2);
        Monom m2 = new Monom(10.2, 1);
        Monom m3 = new Monom(2.6, 2);
        Monom m4 = new Monom(7, 3);

        A.getPolinom().put(1,m1);
        A.getPolinom().put(2,m3);
        C = op.derivare(A);
        assertEquals(C.toString(), "+9.2*x^1");

        B.getPolinom().put(4,m2);
        C=op.derivare(B);
        assertEquals(C.toString(),"+10.2");

        B.getPolinom().remove(4,m2);
        B.getPolinom().put(4,m4);
        B.getPolinom().put(5,m1);
        C=op.derivare(B);
        assertEquals(C.toString(),"+4.0*x^1+21.0*x^2");
        assertNotEquals(C.toString(),"1");


    }

    @Test
    public  void testIntegrare(){
        Operatii op = new Operatii();
        Polynomial A = new Polynomial();
        Polynomial B = new Polynomial();
        Polynomial C = new Polynomial();

        Monom m1 = new Monom(2, 2);
        Monom m2 = new Monom(10.2, 1);
        Monom m3 = new Monom(2.6, 2);
        Monom m4 = new Monom(7, 3);

        A.getPolinom().put(1,m1);
        A.getPolinom().put(2,m3);
        C = op.integrare(A);
        assertEquals(C.toString(), "+1.5333333333333332*x^3");

        B.getPolinom().put(4,m2);
        C=op.integrare(B);
        assertEquals(C.toString(),"+5.1*x^2");

        B.getPolinom().remove(4,m2);
        B.getPolinom().put(4,m4);
        B.getPolinom().put(5,m1);
        C=op.integrare(B);
        assertEquals(C.toString(),"+0.6666666666666666*x^3+1.75*x^4");
        assertNotEquals(C.toString(),"1");


    }
}