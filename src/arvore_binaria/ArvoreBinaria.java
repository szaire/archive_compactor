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

    // TODO: implementar o dicionário
    public void subPRE_ORDER(NodeP refNode) {
        System.out.print(refNode.data + " ");

        if (refNode.left != null) {
            code += "0";
            subPRE_ORDER(refNode.left);
        }

        if (refNode.right != null) {
            code += "1";
            subPRE_ORDER(refNode.right);
        }

        if (refNode.data != '\0') {
            this.dictionary.enqueue(refNode.data, code);
        }
        if (code.length() > 0) {
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
