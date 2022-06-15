import arvore_binaria.ArvoreBinaria;
<<<<<<< HEAD:src/Descompactor.java
import node.NodeCrazy;
=======
import node.NodeP;
>>>>>>> 1bd94c98a6e9c82c6e2fe435d94a151cf76ba281:src/Descompactador.java

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Descompactador
{
    private NodeCrazy tree;
    private String[] lines;
    private int indexCounter;

<<<<<<< HEAD:src/Descompactor.java
    public Descompactor() {
=======
    public Descompactador() {
        this.huffmanTree = new ArvoreBinaria();
>>>>>>> 1bd94c98a6e9c82c6e2fe435d94a151cf76ba281:src/Descompactador.java
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

<<<<<<< HEAD:src/Descompactor.java
    public int convertBinaryToDecimal(String number) {
        double convertedDouble = 0;

        for (int i = 0; i < number.length(); i++) {

            if (number.charAt(i) == '1') {
                int len = number.length() - 1 - i;
                convertedDouble += Math.pow(2, len);
            }
        }

        return (int) convertedDouble;
    }

    private void descompactarArvore(NodeCrazy raiz) {
        String line1 = this.lines[0];
        if (line1.charAt(this.indexCounter) == '0') {
            raiz.setLeft(new NodeCrazy());
            this.indexCounter++;
            descompactarArvore(raiz.getLeft());
        } else if (line1.charAt(this.indexCounter) == '1') {
            String numbers = "";
            this.indexCounter++; // NÃO MEXER NISSO!
            for (int i = 0; i < 8; i++) {
                char digit = line1.charAt(this.indexCounter);
                this.indexCounter++;
                numbers += digit;
            }
            //System.out.println(numbers.toString());
            int dado = convertBinaryToDecimal(numbers);
            //System.out.println(dado);
            raiz.setData((char) dado);
            return;
        }
        //System.out.println(this.indexCounter);
        raiz.setRight(new NodeCrazy());
        descompactarArvore(raiz.getRight());
    }

    public void printTree (NodeCrazy tree) {
        System.out.println(tree.getData());
        if (tree.getLeft() != null){
            printTree(tree.getLeft());
        }
        if (tree.getRight() != null){
            printTree(tree.getRight());
        }
=======
    private void descompactarArvore() {
        String line1 = this.lines[0];
        huffmanTree.setRoot(new NodeP('\0'));


>>>>>>> 1bd94c98a6e9c82c6e2fe435d94a151cf76ba281:src/Descompactador.java
    }

    public String readTree () {
        String line2 = this.lines[1];
        String textoDescompactado = "";
        NodeCrazy tree = this.tree;

        for (int i = 0; i < line2.length(); i++) {
            char caractere = line2.charAt(i);
            if (caractere == '0') {
                tree = tree.getLeft();
            }
            if (caractere == '1') {
                tree = tree.getRight();
            }
            if (tree.getLeft() == null && tree.getRight() == null){
                textoDescompactado += tree.getData();
                tree = this.tree;
            }
        }
        return textoDescompactado;
    }

    public static void writeFile(String fileName, String text) { // Escrever o arquivo compactado
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+".descompactado.txt"));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void execute(String FileNameCompressed) {
        readFile(FileNameCompressed);
        this.tree = new NodeCrazy();
        descompactarArvore(this.tree);
        writeFile(FileNameCompressed,readTree());
    }
}
