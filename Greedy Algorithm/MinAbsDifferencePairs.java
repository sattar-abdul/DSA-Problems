import java.util.*;

public class MinAbsDifferencePairs{
	public static int minAbsDifference(int A[], int B[]){
		int minDiff = 0;

		// 1. sort both array
		Arrays.sort(A);
		Arrays.sort(B);

		// 2. calculate absolute difference
		for(int i=0; i<A.length; i++){
			minDiff += Math.abs(A[i] - B[i]);
		}

		// 3. Return calculated min absolute difference
		return minDiff;
	}

	public static void main(String[] args) {
        int[] A = {2, 1, 3};
        int[] B = {1, 3, 3};

        System.out.print("Pairs with minimum absolute difference:");
        System.out.println(minAbsDifference(A, B));
    }
}