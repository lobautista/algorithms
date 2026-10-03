package chapter14;

public class LinkedList<T> {
    static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    public LinkedList() {
        this.head = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public T read(int index) {
        Node<T> currentNode = this.head;
        int currentIndex = 0;

        if (currentNode == null || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        while (currentIndex < index) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Index: " + index);
            }
            currentNode = currentNode.next;
            currentIndex ++;
        }
        return currentNode.data;
    }
}
