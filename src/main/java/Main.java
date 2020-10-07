import com.ipiecoles.java.java220.Employe;

import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employe test = new Employe("toto", "tata", "titi", LocalDate.now(), 203.5);
        Employe test2 = new Employe("toto", "tata", "titi", test.getDateEmbauche(), 203.5);
        System.out.println(test.equals(test));
        System.out.println(test.equals(test2));
    }
}