package arvore_binaria;

import dictionary.NodeD;
import fila.FilaDinamica;
import node.NodeP;

// Type: search
public class BinaryTree
{
    // Atribbutes:
    public NodeP root;
    public NodeD[] codeArray;

    // Constructor:
    public BinaryTree() {
        this.root = null;
    }

    // Methods:
    public void setRoot(NodeP node) {
        this.root = node;
    }

    public void setCodeArrayLen(int size) {
        codeArray = new NodeD[size];
    }

    public void printPreOrder() {
        if (this.root != null) {
            subPRE_ORDER(this.root);
            System.out.println();
        }
    }

    // TODO: implementar o dicionário
    public void subPRE_ORDER(NodeP refNode) {
        int index = 0;
        System.out.print(refNode.data + " ");

        if (refNode.left != null) {
            codeArray[index].addCodeNumber("0");
            subPRE_ORDER(refNode.left);
        }

        if (refNode.right != null) {
            codeArray[index].addCodeNumber("1");
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
