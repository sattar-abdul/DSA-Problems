import java.util.Stack;

public class QueueUsingTwoStack {
    public static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() { // O(1)
            return s1.isEmpty();
        }

        public static void add(int data) { // O(n)
            // move all element to s2
            while (!s1.isEmpty()) {
                int top = s1.pop();
                s2.push(top);
            }

            s1.push(data);

            // move all element back to s1
            while (!s2.isEmpty()) {
                int top = s2.pop();
                s1.push(top);
            }
        }

        public static int remove() { // O(1)
            return s1.isEmpty() ? -1 : s1.pop();
        }

        public static int peek() { // O(1)
            return s1.isEmpty() ? -1 : s1.peek();
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();

        }
    }
}
