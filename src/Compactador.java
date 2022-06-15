import arvore_binaria.ArvoreBinaria;
import fila.FilaPrioridade;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Compactador {
	private int[] dados;
	private FilaPrioridade filaFrequencia;
	private ArvoreBinaria huffmanTree;
	private String linha1;
	private String linha2;

	public void readFile(String FileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FileName + ".txt"));
			int[] result = new int[256];
			int index = reader.read();
			while (index != -1) {
				result[index] ++;
				index = reader.read();
			}
			this.dados = result;
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



	public static void printFrequency(int[] data) { // printar a frequência que está no array de 256 caracteres
		for (int i = 0; i < data.length; i++) {
			if (data[i] != 0) {
				char n = (char) i;
				System.out.println(n + " - " + data[i]);
			}
		}
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
	
	public void criarHuffmanTree(String FileName) throws IOException {
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

		// Tradutor do arquivo de texto ".txt" para binário
		BufferedReader reader = new BufferedReader(new FileReader(FileName + ".txt"));
		int auxChar;
		while ((auxChar=reader.read()) != -1) {
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
		/* fase 1: */ readFile(FileName);
		/* fase 2: */ filaDePrioridade();
		/* fase 3: */ criarHuffmanTree(FileName);
		/* fase 4: */ writeFile(FileName, linha1, linha2);
	}
}
