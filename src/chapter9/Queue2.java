package chapter9;

import java.util.Arrays;

public class Queue2 {
    private Object [] elements;
    private int front;
    private int rear;
    private int size;

    public Queue2() {
        this.elements = new Object[8];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        int [] rotatedArr = new int [arr.length];
        for (int i = 0; i < arr.length; i ++) {
            int newPosition = (i + 1) % arr.length;
            rotatedArr[newPosition] = arr[i];

        }

        System.out.println(Arrays.toString(rotatedArr));
    }
}
