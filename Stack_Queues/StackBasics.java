// package Stack_Queues;

import java.util.ArrayList;

public class StackBasics {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() { // O(1)
            return list.size() == 0;
        }

        public void push(int data) { // O(1)
            list.add(data);
        }

        public int pop() { // O(1)
            if (isEmpty()) {
                return -1; // stack is empty
            }

            int tos = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return tos;
        }

        public int peek() {
            if (isEmpty()) {
                return -1; // stack is empty
            }

            return list.get(list.size() - 1);
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
