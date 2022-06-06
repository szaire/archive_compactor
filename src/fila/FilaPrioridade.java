package fila;

import node.NodeP;

public class FilaPrioridade {
    // attributes
    private NodeP first;
    private NodeP last;
    private int nextPos;
    private int indices;

    public FilaPrioridade() {
        this.first = null;
        this.last = null;
        nextPos = 0;
        indices = -1;
    }

    // methods
    public void enqueue(char obj, int level) {
        NodeP newData = new NodeP(obj, level);

        if (first == null) {
            this.first = this.last = newData;
        }
        else {
            // Se o novo dado ter prioridade mais alta
            if (newData.priority <= this.first.priority) {
                newData.next = this.first;
                this.first = newData;
            }
            // Se o novo dado ter prioridade mais baixa
            else if (newData.priority > this.last.priority) {
                this.last.next = newData;
                this.last = newData;
            }
            // Se o novo dado ter prioridade intermediária
            else {
                NodeP temp = this.first;
                while (newData.priority > temp.next.priority) {
                    temp = temp.next;
                }
                newData.next = temp.next;
                temp.next = newData;
            }
        }
        increasePositionRef();
    }

    public void enqueue(NodeP newNode) {
        if (first == null) {
            this.first = this.last = newNode;
        }
        else {
            // Se o novo dado ter prioridade mais baixa
            if (newNode.priority <= this.first.priority) {
                newNode.next = this.first;
                this.first = newNode;
            }
            // Se o novo dado ter prioridade mais baixa
            else if (newNode.priority > this.last.priority) {
                this.last.next = newNode;
                this.last = newNode;
            }
            // Se o novo dado ter prioridade intermediária
            else {
                NodeP temp = this.first;
                while (newNode.priority > temp.next.priority) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        increasePositionRef();
    }

    public Object dequeue() {
        if (!isEmpty()) {
            char dequeue = this.first.data;
            this.first = this.first.next;
            decreasePositionRef();

            return dequeue;
        }
        return null;
    }

    public char front() {
        return this.first.data;
    }

    public void print() {
        System.out.print("[");
        if (!isEmpty()) {
            NodeP temp = this.first;
            for (int i = 0; i < indices; i++) {
                System.out.print("('" + temp.data + "', " + temp.priority + "), ");
                temp = temp.next;
            }
            System.out.print("('" + temp.data + "', " + temp.priority + ")");
        }
        System.out.println("]");
    }

    public char get(int pos) {
        NodeP temp = this.first;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public NodeP getTree() {
        return this.first;
    }

    public int getPriority(int pos) {
        NodeP temp = this.first;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp.priority;
    }

    public void remove(char obj) {
        if (isEmpty()) {
            System.out.println("Lista vazia!");
        }
        else {
            int objIndex = indexOf(obj);

            // if the object index is valid (-1 meaning "nonexistent")
            if (objIndex != -1) {
                NodeP temp = this.first;

                // In the case of being the first element:
                if (objIndex == 0) {
                    this.first = first.next;
                    decreasePositionRef();
                }
                // If the case of being another one besides the first:
                else if (objIndex < this.indices){
                    for (int i = 0; i < objIndex-1; i++) {
                        temp = temp.next;
                    }
                    temp.next = temp.next.next;
                    decreasePositionRef();
                }
                // If it's the last one
                else {
                    for (int i = 0; i < objIndex-1; i++) {
                        temp = temp.next;
                    }
                    this.last = temp;
                    last.next = null;
                    decreasePositionRef();
                }
            }
        }
    }

    public void clear() {
        newObject();
    }

    // Huffman Tree
    public void huffmanizer() {
        while (size() > 1) {
            NodeP nullNode = new NodeP('\0', first.priority + first.next.priority);
            nullNode.left = first;
            nullNode.right= first.next;
            dequeue();
            dequeue();
            enqueue(nullNode);
        }
    }

    // Utils
    public boolean isEmpty() {
        return nextPos == 0;
    }

    public int indexOf(char obj) {
        NodeP temp = first;
        int cnt = 0;

        while (temp != null) {
            if (temp.data == obj) {
                return cnt;
            }
            cnt++;
            temp = temp.next;
        }
        return -1;
    }

    public void decreasePositionRef() {
        this.nextPos--;
        this.indices--;
    }

    public void increasePositionRef() {
        this.nextPos++;
        this.indices++;
    }

    public int size() {
        return nextPos;
    }

    public void newObject() {
        this.first = null;
        this.last = null;
        this.nextPos = 0;
        this.indices = -1;
    }
}
