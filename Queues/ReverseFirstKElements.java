import java.util.*;

public class ReverseFirstKElements {
    public static void reverseFirstKElements(Queue<Integer> q, int k) {
        int n = q.size();
        Stack<Integer> s = new Stack<>();

        // push k elements to stack
        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }

        // move k elements back to queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        // Move remaining n-k elements from front to rear.
        for (int i = 0; i < n - k; i++) {
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverseFirstKElements(q, 3);
        System.out.println(q);
    }
}
