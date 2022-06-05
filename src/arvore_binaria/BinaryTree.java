package arvore_binaria;

import fila_prioridade.NodeP;

// Type: search
public class BinaryTree
{
    // Atribbutes:
    public NodeP root;

    // Constructor:
    public BinaryTree() {
        this.root = null;
    }

    // Methods:
    public void printPreOrder() {
        if (this.root != null) {
            subPRE_ORDER(this.root);
            System.out.println();
        }
    }

    public void subPRE_ORDER(NodeP refNode) {
        System.out.print(refNode.data + " ");

        if (refNode.left != null) {
            subPRE_ORDER(refNode.left);
        }

        if (refNode.right != null) {
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
