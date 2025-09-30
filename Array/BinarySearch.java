public class BinarySearch{

	public static int binarySearch(int arr[], int key) {
		int left = 0;
		int right = arr.length - 1;

		while( left <= right){
			int mid = left + (right - left) / 2;
			if(arr[mid] == key){
				return mid;
			}
			else if(arr[mid] > key){
				//key is in left half
				right = mid-1;
			}
			else {
				//key is in right half
				left = mid+1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};  // sorted array
        int key = 10;
        System.out.println(binarySearch(arr, key));
    }
}