package chapter9;

public class Queue <T>{
    private Object [] elements;
    private int top = -1;

    public Queue () {
        this.elements = new Object[8];
    }

    public void enqueue (T o) {
        if (isFull()) {
            increaseQueue();
        }
        this.elements[++top] = o;
    }

    public T dequeue () {
        T element = (T) this.elements[0];
        shiftElements();
        this.top --;
        return element;
    }

    private void shiftElements() {
        for (int i = 0; i < this.top; i ++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.top] = null;
    }

    public T read () {
        return (T) this.elements[0];
    }

    private boolean isFull() {
        return this.top == this.elements.length - 1;
    }

    private void increaseQueue() {
        Object [] newElements = new Object[this.elements.length * 2];
        for (int i = 0; i < this.elements.length; i ++) {
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }
}
