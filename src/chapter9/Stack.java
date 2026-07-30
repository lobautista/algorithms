package chapter9;

public class Stack<T> {
    private Object [] elements;
    private int top = -1;

    public Stack () {
        this.elements = new Object[1];
    }

    public void push(T o) {
        if (isFull()) {
            increaseStack();
        }
        this.elements[++ this.top] = o;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = (T) this.elements[top];
        this.elements[this.top] = null;
        top--;
        return element;
    }

    public T peek () {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) this.elements[top];
    }

    private boolean isFull() {
        return top == this.elements.length - 1;
    }

    private void increaseStack() {
        Object [] newElements = new Object[this.elements.length * 2];
        for (int i = 0; i < this.elements.length; i ++) {
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
