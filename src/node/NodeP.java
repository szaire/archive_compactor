package node;

public class NodeP
{
    public char data;
    public NodeP next;
    public int priority;

    // binary tree
    public NodeP father;
    public NodeP left; // null
    public NodeP right; // null

    public NodeP(char obj, int level) {
        this.data = obj;
        this.priority = level;
        this.next = null;
    }

    public NodeP(char obj) {
        this.data = obj;
        this.father = null;
        this.left = null;
        this.right= null;
    }
}
