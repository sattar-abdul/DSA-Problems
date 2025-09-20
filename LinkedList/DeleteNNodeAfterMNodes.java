/*  
Delete N Nodes After M Nodes of a Linked List 
We have a linkedlist and two integers M and N.
Traverse the linkedlist such that you retain M nodes then delete next N nodes,
continue the same till end of the linkedlist.
*/

package LinkedList;

public class DeleteNNodeAfterMNodes {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void skipMdeleteN(Node head, int m, int n) {
        Node curr = head, next;
        int i;
        while (curr != null) {
            for (i = 0; i < m - 1 && curr != null; i++) {
                curr = curr.next;
            }

            if (curr == null)
                return;
            next = curr.next;

            for (int j = 0; j < n && next != null; j++) {
                next = next.next;

            }
            curr.next = next;
            curr = next;
        }
    }

    public static void main(String[] args) {
        DeleteNNodeAfterMNodes list = new DeleteNNodeAfterMNodes();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        list.printList(head);
        list.skipMdeleteN(head, 3, 2);
        list.printList(head);

    }
}