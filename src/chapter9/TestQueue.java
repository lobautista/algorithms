package chapter9;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);

        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
        System.out.println(queue.read());
        System.out.println(queue.dequeue());
    }
}
