public class QueueUsingLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() { // O(1)
            if (head == null && tail == null) {
                return true;
            } else
                return false;
        }

        public static void add(int data) { // O(1)
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() { // O(1)
            if (isEmpty()) {
                return -1;
            }

            int data = head.data;

            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }

            return data;

        }

        public static int peek() { // O(1)
            if (isEmpty()) {
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        // 1 2 3

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
