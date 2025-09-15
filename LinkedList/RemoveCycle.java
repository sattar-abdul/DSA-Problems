package LinkedList;

public class RemoveCycle {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        public void removeCycle() {
            // 1.detect cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    cycle = true;
                    break;
                }
            }

            if (!cycle) {
                return;
            }

            // 2. find meeting point of slow and fast
            slow = head;

            while (slow.next != fast.next) {

                fast = fast.next;
                slow = slow.next;
            }

            // 3.remove cycle: prev.next = null
            fast.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = list.head; // cycle

        list.removeCycle();

    }

}
