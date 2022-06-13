import arvore_binaria.ArvoreBinaria;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Descompactor
{
    private ArvoreBinaria huffmanTree;
    private String[] lines;
    private int indexCounter;

    public Descompactor() {
        this.huffmanTree = new ArvoreBinaria();
        this.indexCounter = 0;
    }

    public void readFile(String FileName) { // Ler um arquivo.txt e retornar uma String com as linhas do
        // arquivo concatenadas
        try {
            Scanner reader = new Scanner(new FileReader(FileName + ".txt"));
            this.lines = new String[2];
            int i = 0;
            while (reader.hasNextLine()) {
                this.lines[i] = reader.nextLine();
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException("Arquivo nao encontrado");
        }
    }

    private void descompactarArvore() {
        String line1 = this.lines[1];

        while (indexCounter < line1.length()) {

        }
    }

    public void execute(String FileNameCompressed) {
        readFile(FileNameCompressed);
        descompactarArvore();
//        writeFile();
    }

    // TODO: ler primeira linha -> construir arvore binária
    // TODO: ler segunda linha -> traduzir texto com a árvore binária
}
