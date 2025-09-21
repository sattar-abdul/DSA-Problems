// Odd Even Linked List

package LinkedList;

public class OddEvenLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public Node segregateEvenOdd() {
        Node evenHead = new Node(-1); // dummy node
        Node currEven = evenHead;
        Node oddHead = new Node(-1); // dummy node
        Node currOdd = oddHead;
        Node temp = head;
        while (temp != null) {
            if (temp.data % 2 == 0) {
                currEven.next = temp;
                currEven = currEven.next;
            } else {
                currOdd.next = temp;
                currOdd = currOdd.next;
            }
            temp = temp.next;
        }
        // terminate odd list
        currOdd.next = null;

        // attach odd list after even list
        currEven.next = oddHead.next;
        return evenHead.next;
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OddEvenLL list = new OddEvenLL();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        list.printList();
        list.head = list.segregateEvenOdd();
        list.printList();
    }

}