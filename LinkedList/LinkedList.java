// Merge Sort on Linked List

package LinkedList;

public class LinkedList {
    public Node head;

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

    public void print() { // O(n)
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next; // why head.next? so that we get last elment of 1st half of list as mid

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // assuming give LL has positive numbers only
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {

            // compare each element from list 1 and 2
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        // place remaining element to the list
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
        }
        ;

        return mergedLL.next; // because 1st element is -1
    }

    public Node mergeSort(Node head) { // O (nlogn)
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // 1.Find mid
        Node mid = getMid(head);

        // 2.split the list into 2 parts
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next = null;

        // 3.call merge for both half
        Node newLeft = mergeSort(leftHead);
        Node newRight = mergeSort(rightHead);

        // 4.merge two sorted list
        return merge(newLeft, newRight);

    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(5);
        l1.append(4);
        l1.append(1);
        l1.append(2);
        l1.append(3);

        l1.print();
        l1.head = l1.mergeSort(l1.head);
        l1.print();

    }
}