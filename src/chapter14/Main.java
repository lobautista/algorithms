package chapter14;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("Once");
        linkedList.addFirst("upon");
        linkedList.addFirst("a");
        linkedList.addFirst("time");

        System.out.println(linkedList.read(0));
        System.out.println(linkedList.read(1));
        System.out.println(linkedList.read(2));
        System.out.println(linkedList.read(3));
    }
}
