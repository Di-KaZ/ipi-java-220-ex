import com.ipiecoles.java.java220.Commercial;

import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Commercial test = new Commercial("toto", "tata", "titi", LocalDate.now(), 203.5, 25000.0);
        Commercial test2 = new Commercial("toto", "tata", "titi", test.getDateEmbauche(), 203.5, 25000.0);
        System.out.println(test.equals(test));
        System.out.println(test.equals(test2));
    }
}