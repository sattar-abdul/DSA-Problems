public class ReverseAnArray{
	public static void reverseArray(int arr[]) {
		int len = arr.length;
		for(int i=0; i<len/2; i++){
			// swap first and last element
			int temp = arr[i];
			arr[i] = arr[len-1-i];
			arr[len-1-i] = temp;
		}

	}

	public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
     
        reverseArray(arr);

        for(int element: arr){
        	System.out.print(element + " ");
        }
        System.out.println();
    }
}