
import java.util.ArrayList;

public class QueueUsingArrayalist {

    static class Queue {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.size() == 0;
        }

        // Enqueue
        public void add(int data) {
            list.add(data);
        }

        // Dequeue
        public int remove() {
            if (list.size() == 0) {
                return -1;
            }

            return list.remove(0); // O(n) because of shifting
        }

        // peek
        public int peek() {
            if (list.size() == 0) {
                return -1;
            }
            return list.get(0);
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



