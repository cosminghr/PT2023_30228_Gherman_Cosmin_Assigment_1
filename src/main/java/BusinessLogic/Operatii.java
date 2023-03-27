package BusinessLogic;

import DataModels.Monom;
import DataModels.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static java.lang.Math.round;

public class Operatii {

    public Polynomial verificaGrad(Polynomial p1) {
        Polynomial result = new Polynomial();
        boolean found = false; // set to true if at least one term was added
        for (Monom m1 : p1.getPolinom().values()) {
            found = false;
            for (Monom m2 : result.getPolinom().values()) {
                if (m2.getExponent() == m1.getExponent()) {
                    Monom aux = new Monom(0, 0);
                    aux.setCoeficient(m1.getCoeficient() + m2.getCoeficient());
                    aux.setExponent(m1.getExponent());
                    result.getPolinom().put(m1.getExponent(), aux);
                    found = true;
                    break;
                }
                if (m2.getCoeficient()==0){
                    result.getPolinom().remove(m1.getExponent());
                }
            }
            if (!found) {
                result.getPolinom().put(m1.getExponent(), m1);
            }
        }
        return result;
    }

    public Polynomial adunare(Polynomial p1, Polynomial p2) {
        p1 = verificaGrad(p1);
        p2 = verificaGrad(p2);
        Polynomial result = new Polynomial();

        for (Monom m1 : p1.getPolinom().values()) {
            boolean found = false;
            for (Monom m2 : p2.getPolinom().values()) {
                Monom aux = new Monom(0, 0);
                if (m1.getExponent() == m2.getExponent()) {
                    aux.setCoeficient(m1.getCoeficient() + m2.getCoeficient());
                    aux.setExponent(m1.getExponent());
                    result.getPolinom().put(m1.getExponent(), aux);
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.getPolinom().put(m1.getExponent(), m1);
            }
        }

        for (Monom m2 : p2.getPolinom().values()) {
            if (!result.getPolinom().containsKey(m2.getExponent())) {
                result.getPolinom().put(m2.getExponent(), m2);
            }
        }
        result = verificaGrad(result);
        return result;

    }

    public Polynomial scadere(Polynomial p1, Polynomial p2) {
        p1 = verificaGrad(p1);
        p2 = verificaGrad(p2);
        Polynomial result = new Polynomial();
        Polynomial p2Invers = new Polynomial();

        for (Monom m2 : p2.getPolinom().values()) {
            Monom aux = new Monom(0, 0);
            if (m2.getExponent() == 0) {
                aux.setCoeficient(-1 * m2.getCoeficient());
            } else {
                aux.setExponent(m2.getExponent());
                aux.setCoeficient(-1 * m2.getCoeficient());
            }
            p2Invers.getPolinom().put(aux.getExponent(), aux);
        }

        result = adunare(p1, p2Invers);
        result = verificaGrad(result);

        return result;
    }

    public Polynomial inmultire(Polynomial p1, Polynomial p2) {
        p1 = verificaGrad(p1);
        p2 = verificaGrad(p2);
        Polynomial result1 = new Polynomial();
        Polynomial result = new Polynomial();
        for (Monom m1 : p1.getPolinom().values()) {
            for (Monom m2 : p2.getPolinom().values()) {
                Monom aux = new Monom(0, 0);
                if (m1.getExponent() == 0) {
                    aux.setExponent(m2.getExponent());
                    aux.setCoeficient(m1.getCoeficient() * m2.getCoeficient());
                } else if (m2.getExponent() == 0) {
                    aux.setExponent(m1.getExponent());
                    aux.setCoeficient(m1.getCoeficient() * m2.getCoeficient());
                } else {
                    aux.setExponent(m1.getExponent() + m2.getExponent());
                    aux.setCoeficient(m1.getCoeficient() * m2.getCoeficient());
                }
                for(Monom m3:result.getPolinom().values()){
                    if(m3.getExponent()== aux.getExponent()){
                        aux.setCoeficient(m3.getCoeficient() + aux.getCoeficient());
                    }
                }
                result.getPolinom().put(aux.getExponent(), aux);
                result = verificaGrad(result);
            }
        }
        return result;
    }

    public  Polynomial impartire(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();

        return result;
    }
    public Polynomial derivare(Polynomial p1) {
        p1 = verificaGrad(p1);
        Polynomial result = new Polynomial();
        for (Monom m1 : p1.getPolinom().values()) {
            Monom aux = new Monom(0, 0);
            if(m1.getExponent() !=0) {
                aux.setExponent(m1.getExponent() - 1);
                aux.setCoeficient(m1.getCoeficient() * m1.getExponent());
                result.getPolinom().put(m1.getExponent(), aux);
                //result = verificaGrad(result);
            }else{
                result.getPolinom().put(m1.getExponent(), aux);
            }
        }

        return result;
    }

    public Polynomial integrare(Polynomial p1) {
        p1 = verificaGrad(p1);
        Polynomial result = new Polynomial();
        for (Monom m1 : p1.getPolinom().values()) {
            Monom aux = new Monom(0, 0);
            if (m1.getExponent() == 0) {
                aux.setExponent(m1.getExponent() + 1);
                aux.setCoeficient(m1.getCoeficient());
            } else {
                aux.setExponent(m1.getExponent() + 1);
                aux.setCoeficient((+1.0 / (m1.getExponent() + 1)) * m1.getCoeficient());

            }
            result.getPolinom().put(aux.getExponent(), aux);
            result = verificaGrad(result);
        }
        return result;
    }
    public void verificaParsariGresite(String input) throws Exception{
        String paternGresit1 = ".*[^?((\\d)|(\\d.\\d))+x\\d^+-].*.*"; //definim expresia regulata pentru a verifica daca exista caractere nepermise
        Pattern pattern = Pattern.compile(paternGresit1); //compilam expresia regulata
        Matcher matcher = pattern.matcher(input); //creem un matcher pentru a verifica daca expresia se potriveste cu sirul de intrare
        if(matcher.find()){ //daca expresia nu se potriveste, aruncam o exceptie
            throw new Exception("Pattern gresit!");
        }
    }
    public Polynomial parsePolynomial (String input) throws Exception {
        Polynomial result = new Polynomial();
        verificaParsariGresite(input);
        String monomRegex = "-?((\\d.\\d)|(\\d))*x(\\^\\d+)?|(-?\\d+)"; // definim expresia regulată pentru a extrage fiecare monom din input
        Pattern pattern = Pattern.compile(monomRegex);;
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) { // parcurgem fiecare monom si il adaugam la polinom
            String monom = matcher.group();
            double coeficient = 0;
            int exponent = 0;
            if (monom.contains("x")) { //verificam daca monomul contine un coeficient si/sau exponent
                if (monom.startsWith("-x") || monom.startsWith("x")) {
                    coeficient = Double.parseDouble(monom.replace("x", "").replace("-", "-1"));
                } else {
                    coeficient = Double.parseDouble(monom.substring(0, monom.indexOf("x")));
                }
                if (monom.contains("^")) {
                    exponent = Integer.parseInt(monom.substring(monom.indexOf("^") + 1));
                } else {
                    exponent = 1;
                }
            } else {
                coeficient = Double.parseDouble(monom);
                exponent = 0;
            }
            Monom monom1 = new Monom(coeficient, exponent);// adaugam monomul la polinom
            if(result.getPolinom().containsKey(exponent)){
                coeficient += result.getPolinom().get(exponent).getCoeficient();
                monom1.setCoeficient(coeficient);
            }
            result.getPolinom().put(monom1.getExponent(),monom1);
        }
        return result;
    }

}
