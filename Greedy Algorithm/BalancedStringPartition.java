public class BalancedStringPartition{
	public static int maxBalancedSubstrings(String str){
		int l = 0;
		int r = 0;
		int count = 0;

		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == 'R'){
				r++;
			}else {
				l++;
			}

			if(l == r){
				count++;   // found one balanced substring
				l = r = 0; // reset for next partition
			}
		}
		return count;

	}



	public static void main(String[] args) {
        String s = "LRRRLLLRRLLL";
        System.out.println(maxBalancedSubstrings(s)); // Output: 3
    }
}