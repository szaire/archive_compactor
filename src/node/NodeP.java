package node;

public class NodeP
{
    public char data;
    public NodeP next;
    public int priority;

    // binary tree
    public NodeP left;
    public NodeP right;

    public NodeP(char obj, int level) {
        this.data = obj;
        this.priority = level;
        this.next = null;
    }

    public NodeP(char obj) {
        this.data = obj;
        this.priority = 0;
        this.next = null;
    }
}
