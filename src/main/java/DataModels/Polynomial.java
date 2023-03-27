package DataModels;

import DataModels.Monom;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private HashMap<Integer, Monom> polinom;

    // constructor fara argumente
    public Polynomial() {
        this.polinom = new HashMap<Integer, Monom>();
    }
    // getter pentru polinom
    public HashMap<Integer, Monom> getPolinom() {
        return polinom;
    }

    // setter pentru polinom
    public void setPolinom(HashMap<Integer, Monom> polinom) {
        this.polinom = polinom;
    }

    //metoda toString pentru afisarea polinomului
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        for (Map.Entry<Integer, Monom> monom1 : polinom.entrySet()) {
            Monom monom = monom1.getValue();
            sb.append(monom.toString());//adaugarea unui monom la sfarsitul obiectului de tip StringBuilder
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

}
