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

        Compactador compactador = new Compactador();
        compactador.execute(FileName);

        // Descompactador
        String FileNameCompressed = in.nextLine(); // Digo o nome do arquivo compactado

        Descompactor descompactador = new Descompactor();
        descompactador.execute(FileNameCompressed);

    }
}
