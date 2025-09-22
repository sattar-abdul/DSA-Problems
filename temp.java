import java.util.Stack;

public class temp {

    public static void nextGreaterElement(int arr[], int nge[]) {
        for (int i = 0; i < arr.length; i++) {
            nge[i] = -1; // Default
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    nge[i] = arr[j];
                    break; // stop at first greater element
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 8, 0, 1, 3 };
        int result[] = new int[arr.length];

        nextGreaterElement(arr, result);

        for (int ele : result) {
            System.out.print(ele + " ");
        }
    }

}
