public class MaximumSubarraySum {

	// Brute-force approach: O(n^3)
	public static int maxSubarraySum(int arr[]){
		int maxSum = Integer.MIN_VALUE;
		
		int len = arr.length;

		for(int i=0; i<len; i++){
			for(int j=i; j<len; j++){
				int sum = 0;          // Reset sum for each subarray 
				for(int k=i; k<=j; k++){
					sum += arr[k];
				}
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}

	// Kadane’s Algorithm
	public static int kadanesAlgorithm(int arr[]){
		// If all the element is < 0, return maximum element
		int len = arr.length;
		int count = 0;
		for(int i=0; i<len; i++){
			if(arr[i] < 0){
				count++;
			}
		}

		if(count == len){
			// return maximum element among the list
			int max = Integer.MIN_VALUE;
			for(int i=0; i<len; i++){
				max = Math.max(max, arr[i]);
			}
			return max;
		}

		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<len; i++){
			sum += arr[i];
			if(sum < 0){
				sum = 0;   //resets current Sum if it is less than 0
			}

			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;

	}

	public static void main(String[] args) {
        
        int arr[] = {-1,-2,-3,-4};
        
        System.out.println(kadanesAlgorithm(arr));    
        
        
    }
}