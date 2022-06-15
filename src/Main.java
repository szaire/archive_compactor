import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
<<<<<<< HEAD
        Locale.setDefault(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("###,####,##");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Escolhe ae tua operação\n" +
                    "1 - Compactação\n" +
                    "2 - Descompactação\n" +
                    "0 - Sair");
            System.out.print(">> ");
=======
        Scanner in = new Scanner(System.in);
        Locale.setDefault(new Locale("pt", "BR"));
        DecimalFormat df = new DecimalFormat("###,####,##");

        while (true)
        {
            System.out.println("Tu quer compactar ou descompactar? fale:");
            System.out.println("1 - compactar");
            System.out.println("2 - descompactar");
            System.out.println("0 - sair");
            System.out.print("escolha: ");
>>>>>>> 1bd94c98a6e9c82c6e2fe435d94a151cf76ba281
            int resp = Integer.parseInt(in.nextLine());
            if (resp == 1) {
                // Compactador
                String FileName = in.nextLine(); // Digo o nome do arquivo
<<<<<<< HEAD
=======

                Compactador compactador = new Compactador();
                compactador.execute(FileName);
            }
            else if (resp == 2) {
                // Descompactador
                String FileNameCompressed = in.nextLine(); // Digo o nome do arquivo compactado

                Descompactador descompactador = new Descompactador();
                descompactador.execute(FileNameCompressed);
            }
            else if (resp == 0) {
                System.out.println("até a próximaaaaaaaaaaaaaaaaaaaaªªªªªªªªªªªªªªª");
                break;
            }
            else {
                System.out.println("epa, epa meu amigo, calma lá, você está sendo meio cringe...");
            }
            System.out.println();
        }
>>>>>>> 1bd94c98a6e9c82c6e2fe435d94a151cf76ba281

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
