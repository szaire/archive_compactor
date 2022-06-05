package fila_prioridade;

public class NodeP
{
    public char data;
    public NodeP next;
    public int priority;

    public NodeP(char obj, int level) {
        this.data = obj;
        this.priority = level;
        this.next = null;
    }
}
