package arvore_binaria;

import fila.FilaDinamica;
import node.NodeP;

// Type: search
public class ArvoreBinaria
{
    // Atribbutes:
    public NodeP root;
    public String code;
    public FilaDinamica dictionary;

    // Constructor:
    public ArvoreBinaria() {
        this.root = null;
        this.code = "";
        dictionary = new FilaDinamica();
    }

    // Methods:
    public void setRoot(NodeP node) {
        this.root = node;
    }

    public void printPreOrder() {
        if (this.root != null) {
            subPRE_ORDER(this.root);
            System.out.println();
        }
    }

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
