// Declara o clasă numită Monom
package DataModels;

public class Monom {
    // Declara variabilele de instanță private coeficient și exponent
    private Double coeficient;
    private Integer exponent;

    // constructor care initializeaza valorile coeficientului si exponentului
    public Monom(double coeficient, int exponent) {
        super(); // apeleaza constructorul clasei parinte (Object)
        this.coeficient = coeficient; // atribuie valoarea coeficientului variabilei de instanta
        this.exponent = exponent; // atribuie valoarea exponentului variabilei de instanta
    }

    // metoda getter pentru coeficient
    public double getCoeficient() {
        return coeficient;
    }

    // metoda setter pentru coeficient
    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    // metoda getter pentru exponent
    public int getExponent() {
        return exponent;
    }

    // metoda setter pentru exponent
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    // metoda toString care returneaza o reprezentare sub forma de sir a obiectului  de tip Monom
    @Override
    public String toString() {
        if (coeficient == 0) { // daca coeficientul este zero
            return ""; // returneaza sirul vid
        }
        if (exponent == 0 && coeficient > 0) { // daca exponentul este zero si coeficientul este pozitiv
            return "+" + coeficient; // returneaza sirul "+" urmat de coeficient
        }
        if (exponent == 0 && coeficient < 0) { // daca exponentul este zero si coeficientul este negativ
            return "" + coeficient; // returneaza doar coeficientul ca sir
        }
        if (coeficient == 1) { // daca coeficientul este 1
            return "+x^" + exponent; // returneaza sirul "+x^" urmat de exponent
        }
        if (coeficient == -1) { // daca coeficientul este -1
            return "-x^" + exponent; // returneaza sirul "-x^" urmat de exponent
        }
        if (coeficient < 1 && coeficient > 0) { // daca coeficientul este între 0 si 1
            return "+" + coeficient + "*x^" + exponent; // returneaza sirul "+" urmat de coeficient, "*x^" si exponent
        }
        if (coeficient > -1 && coeficient < 0) { // daca coeficientul este intre -1 si 0
            return coeficient + "*x^" + exponent; // returneazs coeficientul ca sir urmat de "*x^" si exponent
        }
        if (coeficient > 1) { // daca coeficientul este mai mare decat 1
            return "+" + coeficient + "*x^" + exponent; // returneaza sirul "+" urmat de coeficient, "*x^" si exponent
        } else {
            return coeficient + "*x^" + exponent; // returneaza coeficientul ca sir urmat de "*x^" si exponent
        }
    }
}