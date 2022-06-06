package dictionary;

// Nó dicionário

public class NodeD
{
    // Armazena o dado original do caractere
    public char data;
    // Armazena o código de tradução de huffman
    public String code;
    // Armazena o endereço do próximo nó
    public NodeD next;

    public NodeD(char data) {
        this.data = data;
        this.code = "";
        this.next = null;
    }
}
