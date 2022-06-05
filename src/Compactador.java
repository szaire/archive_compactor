import arvore_binaria.BinaryTree;
import fila_prioridade.FilaPrioridade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Compactador {

	public static StringBuilder readFile(String FileName) { // Ler um arquivo.txt e retornar uma String com as linhas do
															// arquivo concatenadas
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FileName + ".txt"));
			String line;
			StringBuilder result = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			return result;
		} catch (IOException e) {
			throw new RuntimeException("Arquivo nao encontrado");
		}
	}

	public static int[] countFrequency(String line) { // contar a frequência de caracteres numa String line
		int[] counting = new int[255];

		for (int i = 0; i < line.length(); i++) {
			int index = (int) line.charAt(i);
			counting[index]++;
		}

		return counting;
	}

	public static void printFrequency(int[] data) { // printar a frequência que está no array de 256 caracteres
		for (int i = 0; i < data.length; i++) {
			if (data[i] != 0) {
				char n = (char) i;
				System.out.println(n + " - " + data[i]);
			}
		}
	}

	public static void main(String[] args) {
		// fase 1:
		Locale.setDefault(new Locale("pt", "BR"));
		DecimalFormat df = new DecimalFormat("###,####,##");
		Scanner in = new Scanner(System.in);
		String FileName = in.nextLine(); // Digo o nome do arquivo

		String line = String.valueOf(readFile(FileName)); // Leio o arquivo e retorno uma string que concatena todas as
														  // linhas do arquivo

		int[] dados = countFrequency(line); // Conto a frequencia dos caracteres na string e coloco tudo num array
		printFrequency(dados);

		// fase 2:
		FilaPrioridade filaFrequencia = new FilaPrioridade(); // Criação da fila de prioridade
		// O loop-for abaixo percorre o array 'dados' até o último índice
		for (int i = 0; i < dados.length; i++) {
			// Se a frequência da letra for diferente de zero (ou
			// seja, se o caractere referido existe no arquivo de
			// texto) acessa-se esse caractere pela posição e o
			// guarda, junto a sua frequência, na fila de prioridade
			if (dados[i] != 0) {
				char letter = (char) i;
				filaFrequencia.enqueue(letter, dados[i]);
			}
		}
		filaFrequencia.print();

		// fase 3:
		BinaryTree bt = new BinaryTree();
		filaFrequencia.huffmanizer();
		filaFrequencia.print();
		bt.root = filaFrequencia.getTree();
		bt.printPreOrder();



//        int i = 233;
//        char a = (char) 115;
//        System.out.println(a);

	}
}
