// Merge k Sorted Lists into a single list
// Time: O(kN) where k = total list, N = total nodes.

package LinkedList;

public class MergeKSortedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    private Node SortedMerge(Node list1, Node list2) {

        Node mergedList = new Node(-1); // dummy node
        Node curr = mergedList;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                curr.next = list1;
                list1 = list1.next;
                curr = curr.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
                curr = curr.next;
            }

        }

        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }

        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }

        return mergedList.next;

    }

    public Node mergeKSortedLists(Node[] arr) {
        Node mergedList = null; // dummy node
        for (Node list : arr) {
            mergedList = SortedMerge(mergedList, list);
        }
        return mergedList;
    }

    // Print list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();

        Node list1 = new Node(1);
        list1.next = new Node(4);


        Node list2 = new Node(3);
        list2.next = new Node(5);

        Node list3 = new Node(2);
        list3.next = new Node(6);
        
        Node arr[] = {list1, list2, list3};

        list1 = obj.mergeKSortedLists(arr);
        obj.printList(list1);
        
    }


}
