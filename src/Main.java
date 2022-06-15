import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("###,####,##");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Escolhe ae tua operação\n" +
                    "1 - Compactação\n" +
                    "2 - Descompactação\n" +
                    "0 - Sair");
            System.out.print(">> ");
            int resp = Integer.parseInt(in.nextLine());
            if (resp == 1) {
                // Compactador
                String FileName = in.nextLine(); // Digo o nome do arquivo

                Compactador compactador = new Compactador();
                compactador.execute(FileName);
            }
            else if (resp == 2) {
                // Descompactador
                String FileNameCompressed = in.nextLine(); // Digo o nome do arquivo compactado
                Descompactor descompactador = new Descompactor();
                descompactador.execute(FileNameCompressed);
            }
            else if (resp == 0) {
                break;
            }
            else {
                System.out.println("Digite um código válido!");
            }
            System.out.println();
            System.out.println();
        }
    }
}
