package fila;

import dictionary.NodeD;

public class FilaDinamica
{
    // attributes
    private NodeD first;
    private NodeD last;
    private int nextPos;
    private int indices;

    public FilaDinamica() {
        this.first = null;
        this.last = null;
        nextPos = 0;
        indices = -1;
    }

    // methods
    public void enqueue(char obj, String code) {
        NodeD newData = new NodeD(obj);
        newData.code = code;

        if (first == null) {
            this.first = this.last = newData;
        }
        else {
            this.last.next = newData;
            this.last = newData;
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
        System.out.print("{");
        if (!isEmpty()) {
            NodeD temp = this.first;
            for (int i = 0; i < indices; i++) {
                System.out.print("'" + temp.data + "'" + ":" + temp.code + ", ");
                temp = temp.next;
            }
            System.out.print("'" + temp.data + "'"  + ":" + temp.code);
        }
        System.out.println("}");
    }

    public void printToString() {
        // print made to fit the beecrowd standards >:(
        if (!isEmpty()) {
            NodeD temp = this.first;
            for (int i = 0; i < indices; i++) {
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }

    public NodeD get(int pos) {
        NodeD temp = this.first;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public String searchCode(char auxChar) {
        NodeD temp = this.first;
        for (int i = 0; i < size(); i++) {
            if (auxChar == temp.data) {
                return temp.code;
            }
            temp = temp.next;
        }
        return null;
    }

    public void remove(char obj) {
        if (isEmpty()) {
            System.out.println("Lista vazia!");
        }
        else {
            int objIndex = indexOf(obj);

            // if the object index is valid (-1 meaning "nonexistent")
            if (objIndex != -1) {
                NodeD temp = this.first;

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

    // Utils
    public boolean isEmpty() {
        return nextPos == 0;
    }

    public int indexOf(char obj) {
        NodeD temp = first;
        int cnt = 0;

        while (temp != null) {
            if (temp.data == (obj)) {
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
