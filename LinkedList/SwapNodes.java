// swapping two Nodes in a Linked List using given keys (data)

package LinkedList;

public class SwapNodes {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void swapNodes(int x, int y) {
        if (x == y)
            return;

        // 1. Find x
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Find y
        Node prevY = null, currY = head;
        while (currY != null &&  currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either not found
        if (currX == null || currY == null) {
            return;
        }

        // If x is not head
        if (prevX != null) {
            prevX.next = currY;
        } else {
            // currX is first element
            head = currY;
        }

        // If y is not head
        if (prevY != null) {
            prevY.next = currX;
        } else {
            // currY is first element
            head = currX;
        }

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

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
        SwapNodes list = new SwapNodes();

        // Build list: 1 -> 2 -> 3 -> 4 -> 5
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        list.printList();

        list.swapNodes(2, 4);

        System.out.println("List after swapping 2 and 4:");
        list.printList();
    }
}
