public class SmallestStringWithSum{
	public static String getSmallestString(int N, int K) {
		char result[] = new char[N];


		// 1.Fill all a's since a is smallest lexicographically
		for(int i=0; i<N; i++){
			result[i] = 'a';
		}

		 // 2. calculate extra sum needed
        int extra = K - N;

        // 3. fill from right
        int index = N-1;

        while(extra > 0 && index >= 0){
        	int add = Math.min(25, extra);
        	result[index] = (char)('a' + add);
        	extra -= add;
        	index--;
        }

        return new String(result);
	}

	public static void main(String[] args) {
        int N = 5, K = 42;
        System.out.println(getSmallestString(N, K));  // Output: aaamz
    }
}