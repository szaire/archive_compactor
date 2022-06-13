import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Compactador
        Locale.setDefault(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("###,####,##");
        Scanner in = new Scanner(System.in);
        String FileName = in.nextLine(); // Digo o nome do arquivo

        Compactador compac = new Compactador();
        compac.execute(FileName);

        // Descompactador
    }
}
