package chapter14;

import java.util.Objects;

public class LinkedList<T> {
    static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = this.head;
        this.head = newNode;
        if (this.tail == null) {
            this.tail = newNode;
        }
    }

    public T read(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> currentNode = this.head;
        for (int i = 0; i < index && currentNode != null; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return currentNode.data;
    }

    public int indexOf(T value) {
        Node<T> currentNode = this.head;
        int currentIndex = 0;
        while (currentNode != null) {
            if (Objects.equals(value, currentNode.data)) {
                return currentIndex;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }
        return -1;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node<T> currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    public void addLastV2(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }
}
