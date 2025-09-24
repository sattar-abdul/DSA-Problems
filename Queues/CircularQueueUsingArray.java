public class CircularQueueUsingArray {
    static class Queue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        Queue(int n) {
            this.arr = new int[n];
            this.size = n;
            front = rear = -1;
        }

        public boolean isEmpty() {
            if (rear == -1 && front == -1) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if ((rear + 1) % size == front) {
                return true;
            }
            return false;
        }

        // Enqueue
        public void add(int data) {
            if (isFull()) {
                System.out.println("queue is full");
                return;
            }
            if (front == -1) { // If queue is empty, update both front and rear
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Dequeue
        public int remove() {
            // Queue is Empty
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            // Extract deleted data
            int data = arr[front];

            if (front == rear) { // Queue has only one element
                front = rear = -1;
            } else { // Queue has multiple element
                front = (front + 1) % size;
            }
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(4);
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
