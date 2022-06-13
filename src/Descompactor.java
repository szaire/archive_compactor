import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Descompactor
{
    // TODO: fazer métodos para abrir arquivo compactado

    public static String[] readFile(String FileName) { // Ler um arquivo.txt e retornar uma String com as linhas do
        // arquivo concatenadas
        try {
            Scanner reader = new Scanner(new FileReader(FileName + ".txt"));
            String line;
            String lines[] = new String[2];
            int i = 0;
            while (reader.hasNextLine()){
                lines[i] = reader.nextLine();
                i++;
            }
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("Arquivo nao encontrado");
        }
    }


    public static void main(String[] args) {
        String firstLine = "0001100010011001111011010100110001010001101001011010011011010101011000010110010000110000000110010101100110111000001";
        String secondLine = "00110110111111010111001111000111100100111110111001110010101000101001010101000111111000001111000011110000011001";
        String [] lines = readFile("output.cringe");
        System.out.println("1 : " + lines[0]);
        System.out.println("2 : " + lines[1]);

    }

    // TODO: ler primeira linha -> construir arvore binária
    // TODO: ler segunda linha -> traduzir texto com a árvore binária
}
