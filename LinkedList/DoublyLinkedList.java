package LinkedList;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    // print ll
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // insert at beginning
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;

        // delete from beginnin

    }

    // Insert at end
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Remove from beginning
    public int removeFromHead(){
        if(head == null) return Integer.MIN_VALUE; // not a valid number

        int tempData = head.data;
        if(head.next == null){
            head = null;
            return tempData;
        }

        head = head.next;
        head.prev = null;
        return tempData;
    }

    // Remove from end
    public int  removeFromTail(){
        int tempData;
        if(head == null) return Integer.MIN_VALUE; // not a valid number
        
        if(head.next == null){
            tempData = head.data;
            head = null;
            return tempData;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tempData = temp.data;
        temp.prev.next = null;
        return tempData;

    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtHead(1);
        dll.insertAtHead(2);
        dll.insertAtHead(3);
        dll.printList();
        System.out.println(dll.removeFromTail());
        dll.printList();

    }

}
