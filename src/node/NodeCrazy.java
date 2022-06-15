package node;

public class NodeCrazy {

    private Object data;
    private NodeCrazy left;
    private NodeCrazy right;

    public Object getData() {
        return data;
    }

    public NodeCrazy() {
        this.left = null;
        this.right = null;
    }

    public void setData(char data) {
        this.data = data;
    }

    public NodeCrazy getLeft() {
        return left;
    }

    public void setLeft(NodeCrazy left) {
        this.left = left;
    }

    public NodeCrazy getRight() {
        return right;
    }

    public void setRight(NodeCrazy right) {
        this.right = right;
    }
}
