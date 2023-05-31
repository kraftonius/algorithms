package seminar3Homework;

public class LinkedList {
    Node head;

    public static class Node {
        int value;
        Node prev;
        Node next;
    }

    public void add(int newValue) {
        Node newNode = new Node();
        newNode.value = newValue;
        newNode.next = head;
        newNode.prev = null;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    public void println(Node node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public void revert() {
        Node temp = null;
        Node current = head;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.println(linkedList.head);
        linkedList.revert();
        System.out.print("--> ");
        linkedList.println(linkedList.head);
    }
}
