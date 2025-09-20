package LinkedList;

public class LinkedListBasic {
    public Node head;
    Node tail;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void prepend(int data) { // O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addAt(int index, int data) { // O(n)
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        if (index == 0) {
            append(data);
            return;
        }

        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List already empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;

    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List already empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;

    }

    public int search(int target) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data == target) {
                return index;
            }
            curr = curr.next;
            index++;

        }
        return -1;
    }

    public void printLL() { // O(n)
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListBasic list = new LinkedListBasic();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);

        list.printLL();
    }

}

