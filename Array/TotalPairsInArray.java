public class TotalPairsInArray{
	public static void findPairs(int arr[]){
		int count = 0;
		int len = arr.length;

		for(int i=0; i<len; i++){
			for(int j=i+1; j<len; j++){
				System.out.print("(" + arr[i] + "," + arr[j] + ")");
				count++;
			}
			System.out.println();
		}
		System.out.println("Total pairs: " + count);
	}

	public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        findPairs(arr);
    }
}