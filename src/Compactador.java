import arvore_binaria.ArvoreBinaria;
import fila.FilaPrioridade;

import java.io.*;

public class Compactador {
	private int[] dados;
	private FilaPrioridade filaFrequencia;
	private ArvoreBinaria huffmanTree;
	private String linha1;
	private String linha2;

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

	public static void writeFile(String fileName, String line1, String line2) { // Escrever o arquivo compactado
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+".cringe.txt"));
			writer.write(line1+"\n");
			writer.write(line2);
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
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

	public void frequencia(String FileName) throws IOException {
		String line = String.valueOf(readFile(FileName)); // Leio o arquivo e retorno uma string que concatena todas as
														  // linhas do arquivo

		this.dados = countFrequency(line); // Conto a frequencia dos caracteres na string e coloco tudo num array
		printFrequency(this.dados);
	}

	public void filaDePrioridade() throws IOException {
		this.filaFrequencia = new FilaPrioridade(); // Criação da fila de prioridade
		// O loop-for abaixo percorre o array 'dados' até o último índice
		for (int i = 0; i < this.dados.length; i++) {
			// Se a frequência da letra for diferente de zero (ou
			// seja, se o caractere referido existe no arquivo de
			// texto) acessa-se esse caractere pela posição e o
			// guarda, junto a sua frequência, na fila de prioridade
			if (this.dados[i] != 0) {
				char letter = (char) i;
				filaFrequencia.enqueue(letter, this.dados[i]);
			}
		}
		filaFrequencia.print();
	}
	
	public void criarHuffmanTree() throws IOException {
		// fase 3:
		// Transformando fila de prioridade em Árvore Binária:
		filaFrequencia.huffmanizer();
		filaFrequencia.print();

		// Guardando a raiz da lista na root de um objeto de Árvore Binária criado
		huffmanTree = new ArvoreBinaria();
		huffmanTree.setRoot(filaFrequencia.getTree());

		// Gerando o dicionário da árvore de huffman
		huffmanTree.printPreOrder();
		huffmanTree.dictionary.print();

		// Compactar a árvore de huffman em binário
		huffmanTree.treeCompactor();
		System.out.println("Arvore de Huffman compactada: " + huffmanTree.getCompactedTree());

		// Tradutor do arquivo de texto "output.txt" para binário
		File output = new File("output.txt");
		FileInputStream fis = new FileInputStream(output);
		int auxChar;
		while ((auxChar=fis.read()) != -1) {
			huffmanTree.binaryTranslator(auxChar);
		}
		System.out.println("Texto em binario: " + huffmanTree.getOutputText());

		this.linha1 = huffmanTree.getCompactedTree();
		this.linha2 = huffmanTree.getOutputText();
	}

	public ArvoreBinaria getHuffmanTree() {
		return huffmanTree;
	}

	public void execute(String FileName) throws IOException {
		/* fase 1: */ frequencia(FileName);
		/* fase 2: */ filaDePrioridade();
		/* fase 3: */ criarHuffmanTree();
		/* fase 4: */ writeFile(FileName, linha1, linha2);
	}
}
