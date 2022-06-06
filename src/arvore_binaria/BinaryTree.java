package arvore_binaria;

import dictionary.NodeD;
import fila.FilaDinamica;
import node.NodeP;

// Type: search
public class BinaryTree
{
    // Atribbutes:
    public NodeP root;
    public FilaDinamica dictionary;
    public String code;

    // Constructor:
    public BinaryTree() {
        this.root = null;
        this.code = null;
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
            if (refNode.left.data == '\0') {
                code += "0";
            }
            else {
                code += "0";
                dictionary.enqueue(refNode.data, code);
            }
            subPRE_ORDER(refNode.left);
        }

        if (refNode.right != null) {
            if (refNode.right.data == '\0') {
                code += "1";
            }
            else {
                code += "1";
                dictionary.enqueue(refNode.data, code);
            }
            subPRE_ORDER(refNode.right);
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
