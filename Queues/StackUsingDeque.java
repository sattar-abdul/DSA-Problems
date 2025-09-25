import java.util.*;

public class StackUsingDeque {

    static class Stack {
        static Deque<Integer> dq = new LinkedList<>();

        public static boolean isEmpty() {
            return dq.isEmpty();
        }

        // push - addLast
        public static void push(int data) {
            dq.addLast(data);
        }

        // pop - removeLast
        public static int pop() {
            return dq.removeLast();
        }

        // peek - peekLast
        public static int peek() {
            return dq.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
