public class BubbleSort {

    public static void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int turn = 0; turn < n - 1; turn++) {
            for (int i = 0; i < n - 1 - turn; i++) {
                if (arr[i] > arr[i + 1]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortOptimized(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int arr[]) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String args[]) {
        int numbs[] = { 8, 3, 2, 5, 4 };
        bubbleSortOptimized(numbs);
        printArray(numbs);
    }
}
