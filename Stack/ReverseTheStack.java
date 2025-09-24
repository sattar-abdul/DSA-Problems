// This approach uses reversing the stack with recursion, without using any other data structure.

import java.util.Stack;

public class ReverseTheStack {

    static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    static void reverse(Stack<Integer> s) {
        // Base case
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        // Recursion
        reverse(s);
        pushAtBottom(s, top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println("Original Stack: " + s);

        reverse(s);

        System.out.println("Reversed Stack: " + s);
    }
}
