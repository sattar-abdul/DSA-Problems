public class KthLargestOddNumberInRange{
	public static int kthOdd(int L, int R, int k){
		for(int i=R; i>=L; i--){
			if(i%2 != 0){
				k -= 1;
			}

			if(k == 0){
				return i;
			}

		}
		return -1;

	}


	public static void main(String args[]){
		int L = -3, R = 3, k = 1;
		System.out.println(kthOdd(L, R, k));
	}
}