public class LargestNumber{
	public static int largest(int arr[]){
		int largest = Integer.MIN_VALUE;   // Represent -Infinity
		for(int ele: arr){
			largest = Math.max(largest, ele);
		}
		return largest;
	}


	public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 4};
        System.out.println(largest(arr));
    }
}