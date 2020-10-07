import org.joda.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate dateEmbauche = LocalDate.now().plusDays(6);
        final Boolean test = dateEmbauche.isAfter(LocalDate.now());
        System.out.println(test);
    }
}