package arvore_binaria;

import fila.FilaDinamica;
import node.NodeP;

// Type: search
public class ArvoreBinaria
{
    // Atribbutes:
    public NodeP root;
    public NodeP refRoot;
    public String code;
    public String compactedTree;
    public String outputText;
    public FilaDinamica dictionary;

    // Constructor:
    public ArvoreBinaria() {
        this.root = null;
        this.code = "";
        this.compactedTree = "";
        this.outputText = "";
        this.dictionary = new FilaDinamica();
    }

    // Methods:
    public void setRoot(NodeP node) {
        this.root = node;
        this.refRoot = root;
        this.refRoot.father = root;
    }

    public void setRefRoot(NodeP node) {
        this.refRoot.father = this.refRoot;
        this.refRoot = node;
    }

    public NodeP getRefRoot() {
        return refRoot;
    }

    public void growUp() {
        this.refRoot = this.refRoot.father;
    }

    public void addToRefNode_LEFT(NodeP newNodeCharacter) {
        this.refRoot.left = newNodeCharacter;
    }

    public void addToRefNode_RIGHT(NodeP newNodeCharacter) {
        this.refRoot.right = newNodeCharacter;
    }

    public void setLeftChild(NodeP refNode, NodeP newNode) {
        refNode.left = newNode;
    }

    public void setRightChild(NodeP refNode, NodeP newNode) {
        refNode.right = newNode;
    }

    public void printPreOrder() {
        if (this.root != null) {
            subPRE_ORDER(this.root);
            System.out.println();
        }
    }

    // ok!
    public void subPRE_ORDER(NodeP refNode) {
        System.out.print(refNode.data + " ");

        // irá acessar os nós esquerdos até encontrar um node sem filhos
        if (refNode.left != null) {
            code += "0";
            subPRE_ORDER(refNode.left);
        }

        // irá acessar os nós direitos até encontrar um node sem filhos
        if (refNode.right != null) {
            code += "1";
            subPRE_ORDER(refNode.right);
        }

        // quando encontrar o node sem filhos, verificará se é diferente de nulo
        if (refNode.data != '\0') {
            // se for, adicionará este na fila do dicionário e guardará seu código binário
            this.dictionary.enqueue(refNode.data, code);
        }
        // irá verificar se o código binário é maior que 0 (para evitar null pointer exception)
        if (code.length() > 0) {
            // irá tirar o último digito da string code para que se possa colocar outros futuramente
            this.code = code.substring(0, code.length()-1);
        }
    }

    // compactador da Árvore Binária
    // TODO: Adicionar na Classe da Árvore Binária em Casa
    public void treeCompactor() {
        if (!isEmpty()) {
            subTREE_COMPACTOR(this.root);
        }
    }
    private void subTREE_COMPACTOR(NodeP refNode) {
        if (refNode.data == '\0') {
            compactedTree += "0";

            if (refNode.left != null) {
                subTREE_COMPACTOR(refNode.left);
            }
            if (refNode.right != null) {
                subTREE_COMPACTOR(refNode.right);
            }
        }
        else {
            compactedTree += "1";
            String binary = String.format("%8s", Integer.toBinaryString(refNode.data)).replace(' ', '0');
            compactedTree += binary;
        }
    }
    public String getCompactedTree() {
        return compactedTree;
    }

    // Tradutor do texto para binário:
    public void binaryTranslator(int auxChar) {
        if (!isEmpty()) {
           outputText += dictionaryCode((char) auxChar);
        }
    }
    public String dictionaryCode(char auxChar) {
        return dictionary.searchCode(auxChar);
    }
    public String getOutputText() {
        return outputText;
    }

    // Utils:
    public boolean isEmpty() {
        return this.root == null;
    }

    public int smallestValue(NodeP refNode) {
        if (refNode.left == null) {
            return refNode.data;
        }
        return smallestValue(refNode.left);
    }
}
