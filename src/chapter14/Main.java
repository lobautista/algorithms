package chapter14;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.addLastV2("Once");
        linkedList.addLastV2("upon");
        linkedList.addLastV2("a");
        linkedList.addLastV2("time");

        System.out.println(linkedList.read(0));
        System.out.println(linkedList.read(1));
        System.out.println(linkedList.read(2));
        System.out.println(linkedList.read(3));

        System.out.println();

        System.out.println(linkedList.indexOf("Once"));
        System.out.println(linkedList.indexOf("upon"));
        System.out.println(linkedList.indexOf("a"));
        System.out.println(linkedList.indexOf("time"));
        System.out.println(linkedList.indexOf("Hi"));
    }
}
