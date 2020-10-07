import com.ipiecoles.java.java220.Commercial;
import com.ipiecoles.java.java220.Manager;
import com.ipiecoles.java.java220.Technicien;

import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Manager test = new Manager();
        Technicien test2 = new Technicien();
        test.ajoutTechnicienEquipe(test2);
    }
}