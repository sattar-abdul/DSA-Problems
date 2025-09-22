import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreater(int arr[]) {
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> s = new Stack<>();

        // traverse right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove smaller or equal element
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // If stack empty → no greater element
            if (s.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = arr[s.peek()];
            }

            // push current element to stack
            s.push(i);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 25 };
        int[] res = nextGreater(arr);

        System.out.print("Next Greater Elements: ");
        for (int val : res) {
            System.out.print(val + " ");
        }

    }
}
