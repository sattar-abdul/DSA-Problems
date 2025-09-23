import java.util.Stack;

public class Palindrome {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public static boolean isPalindrome(Node head) {

        // push all the data to stack
        Stack<Integer> s = new Stack<>();
        Node slow = head;
        while (slow != null) {
            s.push(slow.data);
            slow = slow.next;
        }

        // reset slow
        slow = head;

        // compare each data from ll and stack
        while (slow != null) {
            int top = s.pop();
            if (slow.data != top) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));
    }

}
